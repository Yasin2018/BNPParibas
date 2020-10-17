package com.hackerrank.weather.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hackerrank.weather.repository.WeatherRepository;
@Service
public class WeatherService {




        @Autowired
        WeatherRepository weatherRepository;
        public List<Weather> getAllWeatherData() throws EntityNotFoundException{

            if( weatherRepository.findAll().isEmpty()) {
                throw new EntityNotFoundException("No Weather Data Found");

            }else {
                return weatherRepository.findAll();
            }

        }

        public Order getWeather(Long id) {

            if(weatherRepository.findById(id).isPresent()){
                return weatherRepository.findById(id).get();
            }else{
                throw new EntityNotFoundException("Weather Id " + id + " not found");
            }

        }

        public void addWeather(Weather weather) {

            weatherRepository.save(weather);

        }

        public void updateWeather(Weather weather) {

            weatherRepository.save(order);
        }

        public void deleteWeather(Long id) {


            weatherRepository.deleteById(orderId);

        }


    }
