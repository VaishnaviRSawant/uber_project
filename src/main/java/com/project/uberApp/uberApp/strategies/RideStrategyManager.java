package com.project.uberApp.uberApp.strategies;


import com.project.uberApp.uberApp.strategies.impl.DriverMatchingHighestRateDriverStrategy;
import com.project.uberApp.uberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.project.uberApp.uberApp.strategies.impl.RideFareDefaultFareCalculationStrategy;
import com.project.uberApp.uberApp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private  final DriverMatchingHighestRateDriverStrategy highestRatedDriverStrategy;
    private  final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private  final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RideFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;


    public  DriverMatchingStrategy driverMatchingStrategy(double riderRating){
         if(riderRating >= 4.8){
             return  highestRatedDriverStrategy;
         }
         else {
             return  nearestDriverStrategy;
         }
    }

    public  RideFareCalculationStrategy rideFareCalculationStrategy(){


        LocalTime surgeStartTime = LocalTime.of(10,0);

        LocalTime surgeEndTime = LocalTime.of(21,0);

        LocalTime currentTime = LocalTime.now();


        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if (isSurgeTime){
            return  surgePricingFareCalculationStrategy;
        }
        else {
            return defaultFareCalculationStrategy;
        }
    }
}
