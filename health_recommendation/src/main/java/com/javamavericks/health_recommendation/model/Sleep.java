package com.javamavericks.health_recommendation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sleep")
@Getter
@Setter
public class Sleep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String description;
    private String benefits;

    @Column(name = "implementation_steps")
    private String implementationSteps;
}
