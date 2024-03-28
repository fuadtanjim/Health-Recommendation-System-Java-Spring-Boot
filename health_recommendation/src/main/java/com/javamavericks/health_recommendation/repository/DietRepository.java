package com.javamavericks.health_recommendation.repository;

import com.javamavericks.health_recommendation.model.diet.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<Diet, Long> {
}
