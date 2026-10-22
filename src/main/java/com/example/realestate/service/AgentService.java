package com.example.realestate.service;

import com.example.realestate.entity.Agent;

import java.util.List;

public interface AgentService {

    Agent createAgent(Agent agent);

    List<Agent> getAllAgents();

    Agent getAgentById(Long id);

    Agent updateAgent(Long id, Agent agent);

    void deleteAgent(Long id);
}