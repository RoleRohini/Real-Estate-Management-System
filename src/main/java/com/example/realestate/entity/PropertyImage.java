package com.example.realestate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "property_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String description;

    private Integer displayOrder;

    private Boolean isPrimary = false;

    @ManyToOne
    @JoinColumn(name = "property_id")
    @JsonBackReference("property-images")
    private Property property;
}