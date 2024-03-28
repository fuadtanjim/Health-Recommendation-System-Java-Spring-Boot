package com.javamavericks.health_recommendation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="health_data")
@Getter
@Setter
public class HealthData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "heart_rate", nullable = false)
    private Integer heartRate;

    @Column(name = "cholesterol", nullable = false)
    private Integer cholesterol;

    @Column(name = "blood_pressure", nullable = false)
    private Integer bloodPressure;

    @Column(name = "electroencephalography", nullable = false)
    private Integer electroencephalography ;

    @JsonIgnore
    @OneToOne(mappedBy = "healthData")
    private User user;

}
