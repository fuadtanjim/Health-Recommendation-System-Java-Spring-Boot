package com.javamavericks.health_recommendation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class RestApiResponse {

    private int statusCode;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object details;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    public static ResponseEntity<Object> buildApiResponseWithoutDetails(int statusCode, String message) {
        return new ResponseEntity<>(RestApiResponse.builder()
                .statusCode(statusCode)
                .message(message)
                .build(),
                HttpStatusCode.valueOf(statusCode));
    }

    public static ResponseEntity<Object> buildApiResponseWithDetails(int statusCode, String message, Object details) {
        return new ResponseEntity<>(RestApiResponse.builder()
                .statusCode(statusCode)
                .message(message)
                .details(details)
                .build(),
                HttpStatusCode.valueOf(statusCode));
    }

    public static ResponseEntity<Object> buildApiResponseWithError(int statusCode, String message, String description) {
        return new ResponseEntity<>(RestApiResponse.builder()
                .statusCode(statusCode)
                .message(message)
                .error(description)
                .build(),
                HttpStatusCode.valueOf(statusCode));
    }
}
