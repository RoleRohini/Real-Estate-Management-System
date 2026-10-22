package com.example.realestate.repository;

import com.example.realestate.entity.AgentReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentReviewRepository extends JpaRepository<AgentReview, Long> {
}