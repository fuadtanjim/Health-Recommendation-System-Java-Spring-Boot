package com.javamavericks.health_recommendation.repository;

import com.javamavericks.health_recommendation.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}
