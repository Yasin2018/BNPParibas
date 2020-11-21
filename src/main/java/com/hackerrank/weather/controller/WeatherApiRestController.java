package com.hackerrank.weather.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hackerrank.weather.service.WeatherService;
import com.hackerrank.weather.service.LocationService;
@RestController
public class WeatherApiRestController {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private Validator validator;


a
    @RequestMapping("/returnAllWeatherData")
    public List<Weather> getAllWeatherDate() throws EntityNotFoundException{
        List<Weather> weatherList=weatherService.getAllWeatherData();
       

        


        return weatherList.;

    }

    @RequestMapping("/getWeather/{id}")
    public Weather Weather(@PathVariable int id) {

        Weather Weather=WeatherService.getWeather(id);
        try {
            WeatherItems=WeatherItemProxy.getItemsByWeatherId(Weather.getWeatherId());
        }catch(Exception e) {
            throw new EntityNotFoundException("No Item Found for Weather Id test:"+WeatherId);
        }

        Weather.setWeatherItems(WeatherItems);
        return Weather;

    }


    @RequestMapping(method=RequestMethod.POST,value="/createWeather/")
    public ResponseEntity<String> addWeather(@RequestBody Weather Weather) {
        Set<ConstraintViolation<Weather>> violations =validator.validate(Weather);
        StringBuilder sb=new StringBuilder();
        if(violations.size()>0) {
            for (ConstraintViolation<Weather> violation : violations) {
                sb.append((violation.getMessage()));

            }
            throw new EntityNotFoundException("Input Validation Failed :\n"+sb.toString());
        }

        WeatherService.createWeather(Weather);

        return ResponseEntity.ok("Weather Added successfully");

    }


    @RequestMapping(method=RequestMethod.PUT,value="/updateWeather/")
    public ResponseEntity<String> updateWeather(@RequestBody Weather Weather) {
        Set<ConstraintViolation<Weather>> violations =validator.validate(Weather);
        StringBuilder sb=new StringBuilder();
        if(violations.size()>0) {
            for (ConstraintViolation<Weather> violation : violations) {
                sb.append((violation.getMessage()));

            }
            throw new EntityNotFoundException("Input Validation Failed :"+sb.toString());
        }
        WeatherService.updateWeather(Weather);

        return ResponseEntity.ok("Weather Updated successfully");

    }


    @RequestMapping(method=RequestMethod.DELETE,value="/deleteWeather/{WeatherId}")
    public void deleteWeather(@PathVariable Long WeatherId) {

        weatherService.deleteWeather(WeatherId);

    }

}
