package com.example.realestate.service;

import com.example.realestate.entity.PropertyImage;

import java.util.List;

public interface PropertyImageService {

    PropertyImage createPropertyImage(PropertyImage propertyImage);

    List<PropertyImage> getAllPropertyImages();

    PropertyImage getPropertyImageById(Long id);

    PropertyImage updatePropertyImage(Long id, PropertyImage propertyImage);

    void deletePropertyImage(Long id);
}