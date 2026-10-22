package com.example.realestate.service.impl;

import com.example.realestate.entity.Agent;
import com.example.realestate.repository.AgentRepository;
import com.example.realestate.service.AgentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

    @Override
    public Agent createAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public Agent getAgentById(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + id));
    }

    @Override
    public Agent updateAgent(Long id, Agent agent) {

        Agent existingAgent = getAgentById(id);

        existingAgent.setLicenseNumber(agent.getLicenseNumber());
        existingAgent.setSpecialization(agent.getSpecialization());
        existingAgent.setBio(agent.getBio());
        existingAgent.setRating(agent.getRating());
        existingAgent.setIsVerified(agent.getIsVerified());
        existingAgent.setAgencyName(agent.getAgencyName());
        existingAgent.setOfficeAddress(agent.getOfficeAddress());
        existingAgent.setPhone(agent.getPhone());
        existingAgent.setEmail(agent.getEmail());
        existingAgent.setYearsOfExperience(agent.getYearsOfExperience());
        existingAgent.setProfileImage(agent.getProfileImage());
        existingAgent.setTotalReviews(agent.getTotalReviews());

        return agentRepository.save(existingAgent);
    }

    @Override
    public void deleteAgent(Long id) {
        Agent agent = getAgentById(id);
        agentRepository.delete(agent);
    }
}