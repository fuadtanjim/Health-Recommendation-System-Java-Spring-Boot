package com.javamavericks.health_recommendation.service;

import com.javamavericks.health_recommendation.model.Feedback;
import com.javamavericks.health_recommendation.model.Track;
import com.javamavericks.health_recommendation.model.User;
import com.javamavericks.health_recommendation.repository.FeedbackRepository;
import com.javamavericks.health_recommendation.repository.TrackRepository;
import com.javamavericks.health_recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TrackRepository trackRepository;

    public void saveData(Feedback feedback, Long id) {
        User user  = userRepository.findById(id).get();

        Track track = new Track();

        String t;
        int cnt = 0;
        String diet = feedback.getDiet().toString();
        if(diet.equals("GOOD")) cnt++;
        String sleep = feedback.getSleep().toString();
        if(sleep.equals("GOOD")) cnt++;
        String exercise = feedback.getExercise().toString();
        if(exercise.equals("GOOD")) cnt++;
        String mh = feedback.getMentalHealth().toString();
        if(mh.equals("GOOD")) cnt++;
        System.out.println(cnt);

        if(cnt<2) {
            t = "progess is poor";
        } else if (cnt>=2 && cnt <=3) {
            t = "Progress is good";
        } else {
            t = "Progress is very good";
        }
        track.setProgress(t);
        user.setTrack(track);
        user.setFeedback(feedback);
        userRepository.save(user);
        //trackRepository.save(track);
       // feedbackRepository.save(feedback);

    }


    public Optional<Feedback> getFeedback(Long id) {
        return feedbackRepository.findById(id);
    }

    public void updateData(Feedback feedback, Long id) {
        User user  = userRepository.findById(id).get();

        Track track = new Track();

        String t;
        int cnt = 0;
        String diet = feedback.getDiet().toString();
        if(diet.equals("GOOD")) cnt++;
        String sleep = feedback.getSleep().toString();
        if(sleep.equals("GOOD")) cnt++;
        String exercise = feedback.getExercise().toString();
        if(exercise.equals("GOOD")) cnt++;
        String mh = feedback.getMentalHealth().toString();
        if(mh.equals("GOOD")) cnt++;
        System.out.println(cnt);

        if(cnt<2) {
            t = "progess is poor";
        } else if (cnt>=2 && cnt <=3) {
            t = "Progress is good";
        } else {
            t = "Progress is very good";
        }
        track.setProgress(t);
        user.setTrack(track);
        user.setFeedback(feedback);
        userRepository.save(user);
    }
}
