package com.example.realestate.service;

import com.example.realestate.entity.Property;

import java.util.List;

public interface PropertyService {

    Property createProperty(Property property);

    List<Property> getAllProperties();

    Property getPropertyById(Long id);

    Property updateProperty(Long id, Property property);

    void deleteProperty(Long id);

    List<Property> searchByCity(String city);

    List<Property> searchByPropertyType(String propertyType);

    List<Property> searchByListingType(String listingType);

    List<Property> searchByPriceRange(Double minPrice, Double maxPrice);

    List<Property> searchByBedrooms(Integer bedrooms);
}