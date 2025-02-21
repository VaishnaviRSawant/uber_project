package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.SignupDto;
import com.project.uberApp.uberApp.dto.UserDto;

public interface AuthService {
    UserDto signup(SignupDto signupDto);

    String login(String email,String password);
    DriverDto onBoardNewDriver(Long userId);

}
