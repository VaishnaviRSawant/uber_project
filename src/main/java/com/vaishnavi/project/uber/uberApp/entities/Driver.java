package com.vaishnavi.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;

    private Boolean available;

    @Column(columnDefinition = "Geometry(Point, 4326)") //for coordinate /location's latitude&longitude
    Point currentLocation;

}
