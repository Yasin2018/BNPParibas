package com.hackerrank.weather.service;

import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import com.hackerrank.weather.repository.LocationRepository;
import com.hackerrank.weather.model.Location;
@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;


    public Location getLocation(String cityName) {

        if(weatherRepository.findById(cityName).isPresent()){
            return locationRepository.findById(cityName).get();
        }else{
            throw new EntityNotFoundException("Location Not found for  " + cityName );
        }

    }

    public void addLocation(Location location) {

        locationRepository.save(location);

    }

    public void updateLocation(Location location) {

        locationRepository.save(location);
    }

    public void deleteLocation(String  cityName) {


        locationRepository.deleteById(cityName);

    }
}
