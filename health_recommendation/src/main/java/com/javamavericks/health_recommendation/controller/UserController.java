package com.javamavericks.health_recommendation.controller;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.ProfileResponse;
import com.javamavericks.health_recommendation.model.RestApiResponse;
import com.javamavericks.health_recommendation.model.User;
import com.javamavericks.health_recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/profile", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getAccountInfoByUserName(@RequestParam(value = "id") Long id) throws AccountServiceException {
        ProfileResponse accountInfoResponse = userService.getProfile(id);
        return RestApiResponse.buildApiResponseWithDetails(HttpStatus.OK.value(), "SUCCESSFULLY FETCHED", accountInfoResponse);
    }

    @GetMapping(path = "/profile-data", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getProfileData(@RequestParam(value = "id") Long id) throws AccountServiceException {
        Optional<User> user = userService.getProfileData(id);
        return RestApiResponse.buildApiResponseWithDetails(HttpStatus.OK.value(), "SUCCESSFULLY FETCHED", user);
    }

    @PutMapping(path = "/profile", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateProfile(@RequestBody ProfileResponse profileResponse, @PathVariable Long id) {
        userService.updateProfile(profileResponse, id);
        return RestApiResponse.buildApiResponseWithoutDetails(HttpStatus.OK.value(), "SUCCESSFULLY UPDATED");
    }
}
