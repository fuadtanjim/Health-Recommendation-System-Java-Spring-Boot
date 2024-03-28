package com.javamavericks.health_recommendation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="mental_health")
@Getter
@Setter
public class MentalHealth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String description;
    private int durationMinutes;
    private String frequency;
    private String benefits;
    private String resources;
}
