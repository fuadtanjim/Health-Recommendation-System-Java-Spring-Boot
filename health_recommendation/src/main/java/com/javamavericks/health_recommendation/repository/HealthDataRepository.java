package com.javamavericks.health_recommendation.repository;

import com.javamavericks.health_recommendation.model.HealthData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthDataRepository extends JpaRepository<HealthData, Long> {
}
