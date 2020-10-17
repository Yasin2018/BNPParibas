package com.hackerrank.weather.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hackerrank.weather.model.Weather;
public interface WeatherRepository extends JpaRepository<Weather,Long> {


}
