package com.project.uberApp.uberApp.services;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.SignupDto;
import com.project.uberApp.uberApp.dto.UserDto;

public interface AuthService {



    String login(String email,String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onBoardNewDriver(Long userId, String vehicleId);

}
