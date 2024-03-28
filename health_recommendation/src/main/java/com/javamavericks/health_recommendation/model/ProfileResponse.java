package com.javamavericks.health_recommendation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileResponse {
    private String firstName;
    private String lastName;
    private String userName;
    private Gender gender;
    private Role role;
    private String contact;
    private String address;
}
