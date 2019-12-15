package com.nainsree.demo.FlightService.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nainsree.demo.FlightService.Entity.Flight;

public interface FlightRepository extends JpaRepository<Flight,Integer>{

	@Query("from Flight where departureCity=:dpCity and arrivingCity=:arrivingCity and departureDate=:depdate")
	List<Flight> findFlight(@Param("dpCity")String toCity,@Param("arrivingCity")String fromCity, @Param("depdate")Date departureDate);
}
