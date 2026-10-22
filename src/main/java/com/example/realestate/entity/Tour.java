package com.example.realestate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDateTime;

@Entity
@Table(name = "tours")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime tourDate;

    private String status;

    private String notes;

    //private Long propertyId;

    //private Long userId;

    private Long agentId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "property_id")
    @JsonBackReference("property-tours")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-tours")
    private User user;
}