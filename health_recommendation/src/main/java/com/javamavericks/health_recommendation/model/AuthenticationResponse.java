package com.javamavericks.health_recommendation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



public class AuthenticationResponse {

    @Getter
    @Setter
    private String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }
}
