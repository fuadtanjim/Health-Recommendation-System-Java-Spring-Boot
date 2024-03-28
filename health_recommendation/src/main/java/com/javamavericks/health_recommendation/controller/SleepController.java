package com.javamavericks.health_recommendation.controller;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.MentalHealth;
import com.javamavericks.health_recommendation.model.RestApiResponse;
import com.javamavericks.health_recommendation.model.Sleep;
import com.javamavericks.health_recommendation.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SleepController {

    @Autowired
    SleepService sleepService;

    @PostMapping(path = "/sleep", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveHealthData(@RequestBody Sleep sleep) {
        sleepService.saveData(sleep);
        return RestApiResponse.buildApiResponseWithoutDetails(HttpStatus.CREATED.value(), "SUCCESSFULLY SAVED");
    }

    @GetMapping(path = "/sleep", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getSleepRecommendation(@RequestParam(value = "id") Long id) throws AccountServiceException {
        Optional<Sleep> healthData = sleepService.getSleepRecommendation(id);
        return RestApiResponse.buildApiResponseWithDetails(HttpStatus.OK.value(), "SUCCESSFULLY FETCHED", healthData);
    }
}
