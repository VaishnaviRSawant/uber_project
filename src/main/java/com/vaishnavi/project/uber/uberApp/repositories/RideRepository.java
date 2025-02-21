package com.vaishnavi.project.uber.uberApp.repositories;

import com.vaishnavi.project.uber.uberApp.entities.Driver;
import com.vaishnavi.project.uber.uberApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {

}
