package com.javamavericks.health_recommendation.service;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.Sleep;
import com.javamavericks.health_recommendation.model.User;
import com.javamavericks.health_recommendation.repository.SleepRepository;
import com.javamavericks.health_recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SleepService {

    @Autowired
    SleepRepository sleepRepository;

    @Autowired
    UserRepository userRepository;

    public void saveData(Sleep sleep) {
        sleepRepository.save(sleep);
    }

    public Optional<Sleep> getSleepRecommendation(Long id) throws AccountServiceException {

        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new AccountServiceException("WARN_INPUT_PARAMETER", HttpStatus.BAD_REQUEST.value(), "Please input valid user id");
        }

        Integer bp = user.get().getHealthData().getBloodPressure();
        if(bp > 120) {
            return sleepRepository.findById(1L);
        } else {
            return sleepRepository.findById(3L);
        }
    }
}
