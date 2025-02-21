package com.project.uberApp.uberApp.dto;

import com.project.uberApp.uberApp.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private  String name,email;
    private Set<Role> roles;
}
