package com.example.realestate.service.impl;

import com.example.realestate.entity.Property;
import com.example.realestate.repository.PropertyRepository;
import com.example.realestate.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Override
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found with id: " + id));
    }

    @Override
    public Property updateProperty(Long id, Property property) {

        Property existingProperty = getPropertyById(id);

        existingProperty.setTitle(property.getTitle());
        existingProperty.setDescription(property.getDescription());
        existingProperty.setPropertyType(property.getPropertyType());
        existingProperty.setListingType(property.getListingType());
        existingProperty.setPrice(property.getPrice());
        existingProperty.setAddress(property.getAddress());
        existingProperty.setCity(property.getCity());
        existingProperty.setState(property.getState());
        existingProperty.setZipCode(property.getZipCode());
        existingProperty.setLatitude(property.getLatitude());
        existingProperty.setLongitude(property.getLongitude());
        existingProperty.setBedrooms(property.getBedrooms());
        existingProperty.setBathrooms(property.getBathrooms());
        existingProperty.setArea(property.getArea());
        existingProperty.setAreaUnit(property.getAreaUnit());
        existingProperty.setYearBuilt(property.getYearBuilt());
        existingProperty.setStatus(property.getStatus());
        existingProperty.setMainImage(property.getMainImage());

        return propertyRepository.save(existingProperty);
    }

    @Override
    public void deleteProperty(Long id) {
        Property property = getPropertyById(id);
        propertyRepository.delete(property);
    }
    @Override
    public List<Property> searchByCity(String city) {
        return propertyRepository.findByCityIgnoreCase(city);
    }

    @Override
    public List<Property> searchByPropertyType(String propertyType) {
        return propertyRepository.findByPropertyTypeIgnoreCase(propertyType);
    }

    @Override
    public List<Property> searchByListingType(String listingType) {
        return propertyRepository.findByListingTypeIgnoreCase(listingType);
    }

    @Override
    public List<Property> searchByPriceRange(Double minPrice, Double maxPrice) {
        return propertyRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Property> searchByBedrooms(Integer bedrooms) {
        return propertyRepository.findByBedroomsGreaterThanEqual(bedrooms);
    }
}
