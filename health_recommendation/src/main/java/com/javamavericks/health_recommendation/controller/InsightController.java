package com.javamavericks.health_recommendation.controller;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.HealthData;
import com.javamavericks.health_recommendation.model.Insight;
import com.javamavericks.health_recommendation.model.RestApiResponse;
import com.javamavericks.health_recommendation.service.InsightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class InsightController {

    @Autowired
    InsightService insightService;

    @GetMapping(path = "/insight", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getInsight(@RequestParam(value = "id") Long id) throws AccountServiceException {
        Insight insight = insightService.getInsight(id);
        return RestApiResponse.buildApiResponseWithDetails(HttpStatus.OK.value(), "SUCCESSFULLY FETCHED", insight);
    }
}
