package com.project.uberApp.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDto {

        private UserDto user;
        private double rating;
}
