package com.javamavericks.health_recommendation.controller;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.Feedback;
import com.javamavericks.health_recommendation.model.MentalHealth;
import com.javamavericks.health_recommendation.model.RestApiResponse;
import com.javamavericks.health_recommendation.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping(path = "/feedback/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveHealthData(@RequestBody Feedback feedback, @PathVariable Long id) {
        feedbackService.saveData(feedback, id);
        return RestApiResponse.buildApiResponseWithoutDetails(HttpStatus.CREATED.value(), "SUCCESSFULLY SAVED");
    }

    @GetMapping(path = "/feedback", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getFeedback(@RequestParam(value = "id") Long id) throws AccountServiceException {
        Optional<Feedback> feedback = feedbackService.getFeedback(id);
        return RestApiResponse.buildApiResponseWithDetails(HttpStatus.OK.value(), "SUCCESSFULLY FETCHED", feedback);
    }

    @PutMapping(path = "/feedback/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateHealthData(@RequestBody Feedback feedback, @PathVariable Long id) {
        feedbackService.updateData(feedback, id);
        return RestApiResponse.buildApiResponseWithoutDetails(HttpStatus.CREATED.value(), "SUCCESSFULLY UPDATED");
    }

}
