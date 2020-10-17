package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,String> {

}
