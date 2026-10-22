package com.example.realestate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentName;

    private String documentType;

    private String fileUrl;

    private String status;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;

    //private Long propertyId;

    //private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-documents")
    private User user;

    @ManyToOne
    @JoinColumn(name = "property_id")
    @JsonBackReference("property-documents")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    @JsonBackReference("agent-documents")
    private Agent agent;
}
