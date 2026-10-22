package com.example.realestate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String propertyType;

    private String listingType;

    private Double price;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private Double latitude;

    private Double longitude;

    private Integer bedrooms;

    private Integer bathrooms;

    private Double area;

    private String areaUnit;

    private Integer yearBuilt;

    private String status;

    private String mainImage;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @JsonManagedReference("property-images")
    private List<PropertyImage> images;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @JsonManagedReference("property-inquiries")
    private List<Inquiry> inquiries;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @JsonManagedReference("property-tours")
    private List<Tour> tours;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @JsonManagedReference("property-documents")
    private List<Document> documents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-properties")
    private User user;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    @JsonBackReference("agent-properties")
    private Agent agent;
}