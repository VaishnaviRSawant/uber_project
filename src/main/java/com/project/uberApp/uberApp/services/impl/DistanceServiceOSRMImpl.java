package com.project.uberApp.uberApp.services.impl;

import com.project.uberApp.uberApp.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_API_BASE_URL = "http://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point src, Point dest) {
        try {
            // Get coordinates - Point uses x for longitude, y for latitude
            Coordinate srcCoord = src.getCoordinate();
            Coordinate destCoord = dest.getCoordinate();

            // OSRM expects longitude,latitude format
            String coordinates = URLEncoder.encode(
                    srcCoord.x + "," + srcCoord.y + ";" + destCoord.x + "," + destCoord.y,
                    StandardCharsets.UTF_8
            );

            // Add query parameters
            String queryParams = "?overview=false&steps=false&annotations=false";

            // Construct the final request URL
            String requestUrl = OSRM_API_BASE_URL + coordinates + queryParams;

            // Log the request URL for debugging
            System.out.println("OSRM Request URL: " + requestUrl);

            // Make the request to OSRM
            OSRMResponseDto responseDto = RestClient.create()
                    .get()
                    .uri(requestUrl)
                    .retrieve()
                    .body(OSRMResponseDto.class);

            // Validate the response
            if (responseDto == null || responseDto.getRoutes() == null || responseDto.getRoutes().isEmpty()) {
                throw new RuntimeException("No route data found in OSRM response");
            }

            // Return the distance in kilometers
            return responseDto.getRoutes().get(0).getDistance() / 1000.0;

        } catch (Exception e) {
            throw new RuntimeException("Error getting data from OSRM: " + e.getMessage());
        }
    }
}

@Data
class OSRMResponseDto {
    private String code;
    private List<OSRMRoute> routes;
    private List<OSRMWaypoint> waypoints;
}

@Data
class OSRMRoute {
    private Double distance;
    private Double duration;
    private String geometry;
}

@Data
class OSRMWaypoint {
    private String name;
    private Double[] location;
    private Double distance;
}