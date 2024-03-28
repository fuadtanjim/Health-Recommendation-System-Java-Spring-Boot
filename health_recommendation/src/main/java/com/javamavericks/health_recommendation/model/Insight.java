package com.javamavericks.health_recommendation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Table(name="insight")
@Getter
@Setter
public class Insight {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;

    @Column(name = "insight", nullable = false)
    private String insight;
}
