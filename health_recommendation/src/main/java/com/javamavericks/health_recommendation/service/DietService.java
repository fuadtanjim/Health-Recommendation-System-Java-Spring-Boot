package com.javamavericks.health_recommendation.service;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.User;
import com.javamavericks.health_recommendation.model.diet.Diet;
import com.javamavericks.health_recommendation.repository.DietRepository;
import com.javamavericks.health_recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietService {

    @Autowired
    DietRepository dietRepository;

    @Autowired
    UserRepository userRepository;

    public Optional<Diet> getDietRecommendation(Long id) throws AccountServiceException {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new AccountServiceException("WARN_INPUT_PARAMETER", HttpStatus.BAD_REQUEST.value(), "Please input valid user id");
        }

        Integer heartRate = user.get().getHealthData().getHeartRate();
        if(heartRate < 90) {
            return dietRepository.findById(1L);
        } else {
            return dietRepository.findById(2L);
        }
    }

    public void saveDiet(Diet diet) {
        dietRepository.save(diet);
    }
}
