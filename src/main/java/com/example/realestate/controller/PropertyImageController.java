package com.example.realestate.controller;

import com.example.realestate.entity.PropertyImage;
import com.example.realestate.service.PropertyImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property-images")
@AllArgsConstructor
public class PropertyImageController {

    private final PropertyImageService propertyImageService;

    @PostMapping
    public ResponseEntity<PropertyImage> createPropertyImage(
            @RequestBody PropertyImage propertyImage) {

        PropertyImage savedImage =
                propertyImageService.createPropertyImage(propertyImage);

        return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PropertyImage>> getAllPropertyImages() {
        return ResponseEntity.ok(propertyImageService.getAllPropertyImages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyImage> getPropertyImageById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                propertyImageService.getPropertyImageById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyImage> updatePropertyImage(
            @PathVariable Long id,
            @RequestBody PropertyImage propertyImage) {

        return ResponseEntity.ok(
                propertyImageService.updatePropertyImage(id, propertyImage)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePropertyImage(
            @PathVariable Long id) {

        propertyImageService.deletePropertyImage(id);

        return ResponseEntity.ok("Property image deleted successfully");
    }
}