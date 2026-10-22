package com.example.realestate.service.impl;

import com.example.realestate.entity.Tour;
import com.example.realestate.repository.TourRepository;
import com.example.realestate.service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    @Override
    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getTourById(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found with id: " + id));
    }

    @Override
    public Tour updateTour(Long id, Tour tour) {

        Tour existingTour = getTourById(id);

        existingTour.setTourDate(tour.getTourDate());
        existingTour.setStatus(tour.getStatus());
        existingTour.setNotes(tour.getNotes());
        existingTour.setProperty(tour.getProperty());
        existingTour.setUser(tour.getUser());
        existingTour.setAgentId(tour.getAgentId());

        return tourRepository.save(existingTour);
    }

    @Override
    public void deleteTour(Long id) {
        Tour tour = getTourById(id);
        tourRepository.delete(tour);
    }
}