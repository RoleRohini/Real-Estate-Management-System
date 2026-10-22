package com.example.realestate.service;

import com.example.realestate.entity.Tour;

import java.util.List;

public interface TourService {

    Tour createTour(Tour tour);

    List<Tour> getAllTours();

    Tour getTourById(Long id);

    Tour updateTour(Long id, Tour tour);

    void deleteTour(Long id);
}