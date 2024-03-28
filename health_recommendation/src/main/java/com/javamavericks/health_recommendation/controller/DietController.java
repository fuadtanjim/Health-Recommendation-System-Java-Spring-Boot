package com.javamavericks.health_recommendation.controller;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.HealthData;
import com.javamavericks.health_recommendation.model.RestApiResponse;
import com.javamavericks.health_recommendation.model.diet.Diet;
import com.javamavericks.health_recommendation.service.DietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DietController {

    @Autowired
    DietService dietService;

    @PostMapping(path = "/diet", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveHealthData(@RequestBody Diet diett) {
        dietService.saveDiet(diett);
        return RestApiResponse.buildApiResponseWithoutDetails(HttpStatus.CREATED.value(), "SUCCESSFULLY SAVED");
    }

    @GetMapping(path = "/diet", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getDietRecommendation(@RequestParam(value = "id") Long id) throws AccountServiceException {
        Optional<Diet> healthData = dietService.getDietRecommendation(id);
        return RestApiResponse.buildApiResponseWithDetails(HttpStatus.OK.value(), "SUCCESSFULLY FETCHED", healthData);
    }
}
