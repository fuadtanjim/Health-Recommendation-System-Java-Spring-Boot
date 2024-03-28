package com.javamavericks.health_recommendation.service;

import com.javamavericks.health_recommendation.exception.AccountServiceException;
import com.javamavericks.health_recommendation.model.ProfileResponse;
import com.javamavericks.health_recommendation.model.User;
import com.javamavericks.health_recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public ProfileResponse getProfile(Long id) throws AccountServiceException {

        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new AccountServiceException("WARN_INPUT_PARAMETER", HttpStatus.BAD_REQUEST.value(), "Please input valid user id");
        }
        return ProfileResponse.builder()
                .firstName(user.get().getFirstName())
                .lastName(user.get().getLastName())
                .userName(user.get().getUsername())
                .gender(user.get().getGender())
                .contact(user.get().getContact())
                .role(user.get().getRole())
                .address(user.get().getAddress())
                .build();

    }

    public Optional<User> getProfileData(Long id) throws AccountServiceException {

        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new AccountServiceException("WARN_INPUT_PARAMETER", HttpStatus.BAD_REQUEST.value(), "Please input valid user id");
        }
        return user;

    }
    public void updateProfile(ProfileResponse profileResponse,Long id) {
        User user = new User();
        user.setId(id);
        user.setFirstName(profileResponse.getFirstName());
        user.setLastName(profileResponse.getLastName());
        user.setUserName(profileResponse.getUserName());
        user.setContact(profileResponse.getContact());
        user.setAddress(profileResponse.getAddress());
        user.setGender(profileResponse.getGender());
        user.setRole(profileResponse.getRole());
        userRepository.save(user);
    }
}
