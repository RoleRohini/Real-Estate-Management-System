package com.example.realestate.controller;

import com.example.realestate.entity.AgentReview;
import com.example.realestate.service.AgentReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agent-reviews")
@AllArgsConstructor
public class AgentReviewController {

    private final AgentReviewService agentReviewService;

    @PostMapping
    public ResponseEntity<AgentReview> createAgentReview(
            @RequestBody AgentReview agentReview) {

        AgentReview savedReview =
                agentReviewService.createAgentReview(agentReview);

        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AgentReview>> getAllAgentReviews() {
        return ResponseEntity.ok(agentReviewService.getAllAgentReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgentReview> getAgentReviewById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                agentReviewService.getAgentReviewById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgentReview> updateAgentReview(
            @PathVariable Long id,
            @RequestBody AgentReview agentReview) {

        return ResponseEntity.ok(
                agentReviewService.updateAgentReview(id, agentReview)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgentReview(
            @PathVariable Long id) {

        agentReviewService.deleteAgentReview(id);

        return ResponseEntity.ok("Agent review deleted successfully");
    }
}