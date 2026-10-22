package com.example.realestate.service;

import com.example.realestate.entity.AgentReview;

import java.util.List;

public interface AgentReviewService {

    AgentReview createAgentReview(AgentReview agentReview);

    List<AgentReview> getAllAgentReviews();

    AgentReview getAgentReviewById(Long id);

    AgentReview updateAgentReview(Long id, AgentReview agentReview);

    void deleteAgentReview(Long id);
}