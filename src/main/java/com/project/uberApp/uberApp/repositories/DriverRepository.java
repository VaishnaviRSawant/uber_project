package com.project.uberApp.uberApp.repositories;

import com.project.uberApp.uberApp.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


// ST_DISTANCE(point1,point2)
//ST_DWITHIN(point1,10000)

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    @Query(value = "SELECT d.*, ST_distance(d.current_location, :pickupLocation) AS distance " +
            "FROM drivers d" +
            "WHERE d.available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000" +
    "ORDER BY distance" +
    "LIMIT 10", nativeQuery = true
    )

    List<Driver>  findTenNearestDrivers(Point pickupLocation);
}
