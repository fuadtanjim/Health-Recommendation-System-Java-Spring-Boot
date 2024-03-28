package com.javamavericks.health_recommendation.controller;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.Exercise;
import com.javamavericks.health_recommendation.model.RestApiResponse;
import com.javamavericks.health_recommendation.model.diet.Diet;
import com.javamavericks.health_recommendation.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @PostMapping(path = "/exercise", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveHealthData(@RequestBody Exercise exercise) {
        exerciseService.saveData(exercise);
        return RestApiResponse.buildApiResponseWithoutDetails(HttpStatus.CREATED.value(), "SUCCESSFULLY SAVED");
    }

    @GetMapping(path = "/exercise", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getExerciseRecommendation(@RequestParam(value = "id") Long id) throws AccountServiceException {
        Optional<Exercise> healthData = exerciseService.getExerciseRecommendation(id);
        return RestApiResponse.buildApiResponseWithDetails(HttpStatus.OK.value(), "SUCCESSFULLY FETCHED", healthData);
    }
}
