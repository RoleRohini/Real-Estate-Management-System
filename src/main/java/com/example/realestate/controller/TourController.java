package com.example.realestate.controller;

import com.example.realestate.entity.Tour;
import com.example.realestate.service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@AllArgsConstructor
public class TourController {

    private final TourService tourService;

    @PostMapping
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        Tour savedTour = tourService.createTour(tour);
        return new ResponseEntity<>(savedTour, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tour>> getAllTours() {
        return ResponseEntity.ok(tourService.getAllTours());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Long id) {
        return ResponseEntity.ok(tourService.getTourById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tour> updateTour(
            @PathVariable Long id,
            @RequestBody Tour tour) {

        return ResponseEntity.ok(tourService.updateTour(id, tour));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTour(@PathVariable Long id) {
        tourService.deleteTour(id);
        return ResponseEntity.ok("Tour deleted successfully");
    }
}