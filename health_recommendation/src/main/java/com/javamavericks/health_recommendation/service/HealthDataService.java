package com.javamavericks.health_recommendation.service;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.HealthData;
import com.javamavericks.health_recommendation.model.User;
import com.javamavericks.health_recommendation.repository.HealthDataRepository;
import com.javamavericks.health_recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class HealthDataService {

    @Autowired
    HealthDataRepository healthDataRepository;

    @Autowired
    UserRepository userRepository;
    public void saveHealthData(HealthData data, Long id) {
        User user  = userRepository.findById(id).get();
        user.setHealthData(data);
//        healthData.setBloodPressure(data.getBloodPressure());
//        healthData.setCholesterol(data.getCholesterol());
//        healthData.setElectroencephalography(data.getElectroencephalography());
        healthDataRepository.save(data);
        userRepository.save(user);
    }

    public Optional<HealthData> getHealthData(Long id) throws AccountServiceException {
        Optional<HealthData> healthData = healthDataRepository.findById(id);
        if(healthData.isEmpty()) {
            throw new AccountServiceException("WARN_INPUT_PARAMETER", HttpStatus.BAD_REQUEST.value(), "Please input valid id");
        }
        return healthData;

    }
}
