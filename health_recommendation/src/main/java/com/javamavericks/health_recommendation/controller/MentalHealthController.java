package com.javamavericks.health_recommendation.controller;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.MentalHealth;
import com.javamavericks.health_recommendation.model.RestApiResponse;
import com.javamavericks.health_recommendation.model.diet.Diet;
import com.javamavericks.health_recommendation.service.MentalHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MentalHealthController {

    @Autowired
    MentalHealthService mentalHealthService;

    @PostMapping(path = "/mental-health", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveHealthData(@RequestBody MentalHealth mentalHealth) {
        mentalHealthService.saveData(mentalHealth);
        return RestApiResponse.buildApiResponseWithoutDetails(HttpStatus.CREATED.value(), "SUCCESSFULLY SAVED");
    }

    @GetMapping(path = "/mental-health", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getDietRecommendation(@RequestParam(value = "id") Long id) throws AccountServiceException {
        Optional<MentalHealth> healthData = mentalHealthService.getMentalHealthRecommendation(id);
        return RestApiResponse.buildApiResponseWithDetails(HttpStatus.OK.value(), "SUCCESSFULLY FETCHED", healthData);
    }
}
