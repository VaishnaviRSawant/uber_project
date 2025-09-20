package com.project.uberApp.uberApp.utils;

import com.project.uberApp.uberApp.dto.PointDto;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;


       public class GeometryUtil {
    public static Point createPoint(PointDto pointDto) {
        if (pointDto == null || pointDto.getCoordinates() == null || pointDto.getCoordinates().length != 2) {
            return null;
        }
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        Coordinate coordinate = new Coordinate(pointDto.getCoordinates()[0], pointDto.getCoordinates()[1]);
        return geometryFactory.createPoint(coordinate);
    }

    public static PointDto createPointDto(Point point) {
        if (point == null) return null;
        return new PointDto(new double[]{point.getX(), point.getY()}, "Point");  // Add "type": "Point"
    }
}