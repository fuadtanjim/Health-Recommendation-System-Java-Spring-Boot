package com.javamavericks.health_recommendation.exception;

import com.javamavericks.health_recommendation.model.RestApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    String errorLog = "ERROR : {}";
    @ExceptionHandler({AccountServiceException.class})
    public ResponseEntity<Object> handleAccountServiceException(AccountServiceException ex) {
        log.info(errorLog, ex.getMessage());
        return RestApiResponse.buildApiResponseWithError(ex.getStatusCode(), ex.getResponseMessage(), ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception ex) {
        log.info(errorLog, ex.getMessage());
        return RestApiResponse.buildApiResponseWithError(505, "INTERNAL_SERVER_ERROR", "Internal server error");
    }
}
