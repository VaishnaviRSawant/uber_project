package com.vaishnavi.project.uber.uberApp.repositories;

import com.vaishnavi.project.uber.uberApp.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// ST_Distance (point1, point2)
//ST.DWithinPOINT1, 10000)

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query(value = "SELECT d.*, ST_Distance(d.current_location,:pickupLocation) AS distance " +
            "FROM drivers d " +
            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000 " +
            "Order BY distance " +
            "LIMIT 10" , nativeQuery = true
    )

    List<Driver> findTenNearestDrivers(Point pickupLocation);
}
