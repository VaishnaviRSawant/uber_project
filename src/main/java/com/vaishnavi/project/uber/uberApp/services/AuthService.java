package com.vaishnavi.project.uber.uberApp.services;

import com.vaishnavi.project.uber.uberApp.dto.DriverDto;
import com.vaishnavi.project.uber.uberApp.dto.SignupDto;
import com.vaishnavi.project.uber.uberApp.dto.UserDto;

public interface AuthService {

    String login (String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId);

}
