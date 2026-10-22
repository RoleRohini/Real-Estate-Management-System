package com.example.realestate.controller;

import com.example.realestate.entity.Agent;
import com.example.realestate.service.AgentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
@AllArgsConstructor
public class AgentController {

    private final AgentService agentService;

    // Create Agent
    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {

        Agent savedAgent = agentService.createAgent(agent);

        return new ResponseEntity<>(savedAgent, HttpStatus.CREATED);
    }

    // Get All Agents
    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents() {

        return ResponseEntity.ok(agentService.getAllAgents());
    }

    // Get Agent By ID
    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable Long id) {

        return ResponseEntity.ok(agentService.getAgentById(id));
    }

    // Update Agent
    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(
            @PathVariable Long id,
            @RequestBody Agent agent) {

        return ResponseEntity.ok(
                agentService.updateAgent(id, agent)
        );
    }

    // Delete Agent
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable Long id) {

        agentService.deleteAgent(id);

        return ResponseEntity.ok("Agent deleted successfully");
    }
}
