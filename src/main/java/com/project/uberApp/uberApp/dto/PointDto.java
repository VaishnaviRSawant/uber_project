package com.project.uberApp.uberApp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values from JSON
public class PointDto {

    @JsonProperty("coordinates")
    private double[] coordinates;

    @JsonProperty("type")
    private String type = "Point"; // Ensure "type": "Point" is always there

    public PointDto(double latitude, double longitude) {
        this.coordinates = new double[]{latitude, longitude};
    }
}