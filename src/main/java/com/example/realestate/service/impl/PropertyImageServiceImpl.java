package com.example.realestate.service.impl;

import com.example.realestate.entity.PropertyImage;
import com.example.realestate.repository.PropertyImageRepository;
import com.example.realestate.service.PropertyImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyImageServiceImpl implements PropertyImageService {

    private final PropertyImageRepository propertyImageRepository;

    @Override
    public PropertyImage createPropertyImage(PropertyImage propertyImage) {
        return propertyImageRepository.save(propertyImage);
    }

    @Override
    public List<PropertyImage> getAllPropertyImages() {
        return propertyImageRepository.findAll();
    }

    @Override
    public PropertyImage getPropertyImageById(Long id) {
        return propertyImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property image not found with id: " + id));
    }

    @Override
    public PropertyImage updatePropertyImage(Long id, PropertyImage propertyImage) {

        PropertyImage existingImage = getPropertyImageById(id);

        existingImage.setImageUrl(propertyImage.getImageUrl());
        existingImage.setDescription(propertyImage.getDescription());
        existingImage.setDisplayOrder(propertyImage.getDisplayOrder());
        existingImage.setIsPrimary(propertyImage.getIsPrimary());
        existingImage.setProperty(propertyImage.getProperty());

        return propertyImageRepository.save(existingImage);
    }

    @Override
    public void deletePropertyImage(Long id) {
        PropertyImage image = getPropertyImageById(id);
        propertyImageRepository.delete(image);
    }
}