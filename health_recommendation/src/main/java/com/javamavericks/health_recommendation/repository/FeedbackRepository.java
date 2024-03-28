package com.javamavericks.health_recommendation.repository;

import com.javamavericks.health_recommendation.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
