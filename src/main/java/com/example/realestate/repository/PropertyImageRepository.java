package com.example.realestate.repository;

import com.example.realestate.entity.PropertyImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyImageRepository extends JpaRepository<PropertyImage, Long> {
}
