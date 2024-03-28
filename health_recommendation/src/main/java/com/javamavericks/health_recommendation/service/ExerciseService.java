package com.javamavericks.health_recommendation.service;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.Exercise;
import com.javamavericks.health_recommendation.model.User;
import com.javamavericks.health_recommendation.repository.ExerciseRepository;
import com.javamavericks.health_recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    UserRepository userRepository;

    public void saveData(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    public Optional<Exercise> getExerciseRecommendation(Long id) throws AccountServiceException {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new AccountServiceException("WARN_INPUT_PARAMETER", HttpStatus.BAD_REQUEST.value(), "Please input valid user id");
        }

        Integer chol = user.get().getHealthData().getCholesterol();
        if(chol > 240) {
            return exerciseRepository.findById(1L);
        } else {
            return exerciseRepository.findById(2L);
        }
    }
}
