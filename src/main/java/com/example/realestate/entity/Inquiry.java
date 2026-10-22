package com.example.realestate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDateTime;

@Entity
@Table(name = "inquiries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    @Column(length = 2000)
    private String message;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


    //private Long userId;

    private Long agentId;

    @ManyToOne
    @JoinColumn(name = "property_id")
    @JsonBackReference("property-inquiries")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-inquiries")
    private User user;
}