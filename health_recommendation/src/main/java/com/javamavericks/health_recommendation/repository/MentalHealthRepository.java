package com.javamavericks.health_recommendation.repository;

import com.javamavericks.health_recommendation.model.MentalHealth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentalHealthRepository extends JpaRepository<MentalHealth,Long> {
}
