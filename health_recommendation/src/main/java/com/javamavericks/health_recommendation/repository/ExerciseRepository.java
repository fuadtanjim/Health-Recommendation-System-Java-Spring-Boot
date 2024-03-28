package com.javamavericks.health_recommendation.repository;

import com.javamavericks.health_recommendation.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
