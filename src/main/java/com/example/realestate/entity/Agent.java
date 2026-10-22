package com.example.realestate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "agents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licenseNumber;
    private String specialization;
    private String bio;
    private Double rating;
    private Boolean isVerified = false;
    private String agencyName;
    private String officeAddress;
    private String phone;
    private String email;

    private Integer yearsOfExperience;
    private String profileImage;
    private Integer totalReviews;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    @JsonManagedReference("agent-reviews")
    private List<AgentReview> reviews;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    @JsonManagedReference("agent-documents")
    private List<Document> documents;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    @JsonManagedReference("agent-properties")
    private List<Property> properties;
}