package com.javamavericks.health_recommendation.service;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.MentalHealth;
import com.javamavericks.health_recommendation.model.User;
import com.javamavericks.health_recommendation.model.diet.Diet;
import com.javamavericks.health_recommendation.repository.MentalHealthRepository;
import com.javamavericks.health_recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentalHealthService {

    @Autowired
    MentalHealthRepository mentalHealthRepository;

    @Autowired
    UserRepository userRepository;
    public void saveData(MentalHealth mentalHealth) {
        mentalHealthRepository.save(mentalHealth);
    }

    public Optional<MentalHealth> getMentalHealthRecommendation(Long id) throws AccountServiceException {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new AccountServiceException("WARN_INPUT_PARAMETER", HttpStatus.BAD_REQUEST.value(), "Please input valid user id");
        }

        Integer eeg = user.get().getHealthData().getElectroencephalography();

        if(eeg > 12) {
            return mentalHealthRepository.findById(1L);
        } else {
            return mentalHealthRepository.findById(2L);
        }
    }
}
