package com.project.uberApp.uberApp.services.impl;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.SignupDto;
import com.project.uberApp.uberApp.dto.UserDto;
import com.project.uberApp.uberApp.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public UserDto signup(SignupDto signupDto) {
        return null;
    }

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}
