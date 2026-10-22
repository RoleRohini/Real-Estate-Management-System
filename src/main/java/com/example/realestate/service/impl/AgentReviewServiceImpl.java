package com.example.realestate.service.impl;

import com.example.realestate.entity.AgentReview;
import com.example.realestate.repository.AgentReviewRepository;
import com.example.realestate.service.AgentReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgentReviewServiceImpl implements AgentReviewService {

    private final AgentReviewRepository agentReviewRepository;

    @Override
    public AgentReview createAgentReview(AgentReview agentReview) {
        return agentReviewRepository.save(agentReview);
    }

    @Override
    public List<AgentReview> getAllAgentReviews() {
        return agentReviewRepository.findAll();
    }

    @Override
    public AgentReview getAgentReviewById(Long id) {
        return agentReviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent review not found"));
    }

    @Override
    public AgentReview updateAgentReview(Long id, AgentReview agentReview) {

        AgentReview existingReview = getAgentReviewById(id);

        existingReview.setRating(agentReview.getRating());
        existingReview.setComment(agentReview.getComment());
        existingReview.setCreatedAt(agentReview.getCreatedAt());
        existingReview.setAgent(agentReview.getAgent());
        existingReview.setUser(agentReview.getUser());

        return agentReviewRepository.save(existingReview);
    }

    @Override
    public void deleteAgentReview(Long id) {
        AgentReview existingReview = getAgentReviewById(id);
        agentReviewRepository.delete(existingReview);
    }
}