package com.project.uberApp.uberApp.services.impl;

import com.project.uberApp.uberApp.dto.DriverDto;
import com.project.uberApp.uberApp.dto.SignupDto;
import com.project.uberApp.uberApp.dto.UserDto;
import com.project.uberApp.uberApp.entities.Rider;
import com.project.uberApp.uberApp.entities.User;
import com.project.uberApp.uberApp.entities.enums.Role;
import com.project.uberApp.uberApp.exceptions.RuntimeConflictException;
import com.project.uberApp.uberApp.repositories.UserRepository;
import com.project.uberApp.uberApp.services.AuthService;
import com.project.uberApp.uberApp.services.RiderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
    public  UserDto signup(SignupDto signupDto){

        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user != null)
            throw new RuntimeConflictException("Cannot signup, User already exists with email"+signupDto.getEmail());



        User mappedUser = modelMapper.map(signupDto,User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        // create user related entities

        riderService.createNewRider(savedUser);

        //TODO WALLET related service here

        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}
