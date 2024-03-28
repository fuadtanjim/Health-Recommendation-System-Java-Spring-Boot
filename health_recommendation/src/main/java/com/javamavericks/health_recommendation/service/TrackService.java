package com.javamavericks.health_recommendation.service;

import com.javamavericks.health_recommendation.model.Feedback;
import com.javamavericks.health_recommendation.model.Track;
import com.javamavericks.health_recommendation.model.User;
import com.javamavericks.health_recommendation.repository.TrackRepository;
import com.javamavericks.health_recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrackService {

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    UserRepository userRepository;


//    public void saveData(Track track, Long id) {
//        User user  = userRepository.findById(id).get();
//        user.setTrack(track);
//        trackRepository.save(track);
//        userRepository.save(user);
//    }

    public Track getTrack(Long id) {

        User user = userRepository.findById(id).get();

        return user.getTrack();
    }
}
