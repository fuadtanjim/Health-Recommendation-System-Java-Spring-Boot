package com.javamavericks.health_recommendation.controller;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.Feedback;
import com.javamavericks.health_recommendation.model.RestApiResponse;
import com.javamavericks.health_recommendation.model.Track;
import com.javamavericks.health_recommendation.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TrackController {

    @Autowired
    TrackService trackService;


//    @PostMapping(path = "/track/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Object> saveHealthData(@RequestBody Track track, @PathVariable Long id) {
//        trackService.saveData(track, id);
//        return RestApiResponse.buildApiResponseWithoutDetails(HttpStatus.CREATED.value(), "SUCCESSFULLY SAVED");
//    }

    @GetMapping(path = "/track", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getTrack(@RequestParam(value = "id") Long id) throws AccountServiceException {
        Track track = trackService.getTrack(id);
        return RestApiResponse.buildApiResponseWithDetails(HttpStatus.OK.value(), "SUCCESSFULLY FETCHED", track);
    }
}
