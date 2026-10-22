package com.example.realestate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDateTime;

@Entity
@Table(name = "agent_reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating;

    @Column(length = 2000)
    private String comment;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    //private Long agentId;

   // private Long userId;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    @JsonBackReference("agent-reviews")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-agent-reviews")
    private User user;
}
