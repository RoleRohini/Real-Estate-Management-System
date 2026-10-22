package com.example.realestate.controller;

import com.example.realestate.entity.Property;
import com.example.realestate.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@AllArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    // Create Property
    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {

        Property savedProperty = propertyService.createProperty(property);

        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

    // Get All Properties
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {

        List<Property> properties = propertyService.getAllProperties();

        return ResponseEntity.ok(properties);
    }

    // Get Property By ID
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {

        Property property = propertyService.getPropertyById(id);

        return ResponseEntity.ok(property);
    }

    // Update Property
    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(
            @PathVariable Long id,
            @RequestBody Property property) {

        Property updatedProperty =
                propertyService.updateProperty(id, property);

        return ResponseEntity.ok(updatedProperty);
    }

    // Delete Property
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id) {

        propertyService.deleteProperty(id);

        return ResponseEntity.ok("Property deleted successfully");
    }

    @GetMapping("/search/city/{city}")
    public ResponseEntity<List<Property>> searchByCity(
            @PathVariable String city) {

        return ResponseEntity.ok(
                propertyService.searchByCity(city)
        );
    }

    @GetMapping("/search/type/{propertyType}")
    public ResponseEntity<List<Property>> searchByPropertyType(
            @PathVariable String propertyType) {

        return ResponseEntity.ok(
                propertyService.searchByPropertyType(propertyType)
        );
    }

    @GetMapping("/search/listing/{listingType}")
    public ResponseEntity<List<Property>> searchByListingType(
            @PathVariable String listingType) {

        return ResponseEntity.ok(
                propertyService.searchByListingType(listingType)
        );
    }

    @GetMapping("/search/price")
    public ResponseEntity<List<Property>> searchByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {

        return ResponseEntity.ok(
                propertyService.searchByPriceRange(minPrice, maxPrice)
        );
    }

    @GetMapping("/search/bedrooms/{bedrooms}")
    public ResponseEntity<List<Property>> searchByBedrooms(
            @PathVariable Integer bedrooms) {

        return ResponseEntity.ok(
                propertyService.searchByBedrooms(bedrooms)
        );
    }
}