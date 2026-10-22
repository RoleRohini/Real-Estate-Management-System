package com.example.realestate.repository;

import com.example.realestate.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByCityIgnoreCase(String city);

    List<Property> findByPropertyTypeIgnoreCase(String propertyType);

    List<Property> findByListingTypeIgnoreCase(String listingType);

    List<Property> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Property> findByBedroomsGreaterThanEqual(Integer bedrooms);
}