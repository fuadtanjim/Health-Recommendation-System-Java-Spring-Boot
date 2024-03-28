package com.javamavericks.health_recommendation.service;

import com.javamavericks.health_recommendation.model.Insight;
import com.javamavericks.health_recommendation.model.User;
import com.javamavericks.health_recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsightService {

    @Autowired
    UserRepository userRepository;
    public Insight getInsight(Long id) {

        User user = userRepository.findById(id).get();
        String diet = user.getFeedback().getDiet().toString();
        String sleep = user.getFeedback().getSleep().toString();
        String mh = user.getFeedback().getMentalHealth().toString();
        String exercise = user.getFeedback().getExercise().toString();
        String s = "You have achieved your goal on ";
        String goal = "";
        if(diet.equals("GOOD")) {
            goal += "diet";
            goal += ", ";
        }
        if(sleep.equals("GOOD")) {
            goal += "sleep";
            goal += ", ";
        }
        if(mh.equals("GOOD")) {
            goal += "mental health";
            goal += ", ";
        }
        if(exercise.equals("GOOD")) {
            goal += "exercise";
        } else {
            if(!goal.isEmpty()) {
                goal = goal.substring(0, goal.length() - 2);
            }
        }
        if(goal.isEmpty()) {
            goal = "You have not achieved any of your goal";
            s = "";
        }
        s += goal;

        Insight insight = new Insight();
        insight.setInsight(s);
        return insight;
    }
}
