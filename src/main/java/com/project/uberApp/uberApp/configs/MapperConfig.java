package com.project.uberApp.uberApp.configs;

import com.project.uberApp.uberApp.dto.PointDto;
import com.project.uberApp.uberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        // Convert PointDto -> Point
        mapper.typeMap(PointDto.class, Point.class).setConverter(converter -> {
            PointDto pointDto = converter.getSource();
            return GeometryUtil.createPoint(pointDto);
        });

        // Convert Point -> PointDto
        mapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
            Point point = context.getSource();
            if (point == null) return null;

            return new PointDto(new double[]{point.getX(), point.getY()}, "Point");  // Add "type": "Point"
        });

        return mapper;
    }
}