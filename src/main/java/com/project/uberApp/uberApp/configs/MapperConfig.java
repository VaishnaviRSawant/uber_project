package com.project.uberApp.uberApp.configs;

import com.project.uberApp.uberApp.dto.PointDto;
import com.project.uberApp.uberApp.utils.GeomertyUtil;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        
        ModelMapper mapper =  new ModelMapper();
        mapper.typeMap(PointDto.class, Point.class).setConverter(context ->{
            PointDto pointDto = context.getSource();
            return GeomertyUtil.createPoint(pointDto);
        });

        mapper.typeMap(Point.class,PointDto.class).setConverter(context ->{
           Point  point = context.getSource();
           double coordinates[] = {
                   point.getX(),
                   point.getY()
           };
           return  new PointDto(coordinates);
        });

        return  mapper;
    }
}
