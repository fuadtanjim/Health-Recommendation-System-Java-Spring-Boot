package com.javamavericks.health_recommendation.controller;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.HealthData;
import com.javamavericks.health_recommendation.model.RestApiResponse;
import com.javamavericks.health_recommendation.service.HealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class HealthDataController {

    @Autowired
    HealthDataService healthDataService;

    @PostMapping(path = "/health-data/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveHealthData(@RequestBody HealthData healthData, @PathVariable Long id) {
        healthDataService.saveHealthData(healthData, id);
        return RestApiResponse.buildApiResponseWithoutDetails(HttpStatus.CREATED.value(), "SUCCESSFULLY SAVED");
    }

    @GetMapping(path = "/health-data", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getAccountInfoByUserName(@RequestParam(value = "id") Long id) throws AccountServiceException {
        Optional<HealthData> healthData = healthDataService.getHealthData(id);
        return RestApiResponse.buildApiResponseWithDetails(HttpStatus.OK.value(), "SUCCESSFULLY FETCHED", healthData);
    }

}
