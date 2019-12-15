package com.nainsree.demo.FlightService.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.nainsree.demo.FlightService.Entity.Flight;
import com.nainsree.demo.FlightService.Repositories.FlightRepository;
@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepo;
	public List<Flight> getFlightList()
	{
		return flightRepo.findAll();
		//return flightRepo.findById(1)
		
	}
	public Optional<Flight> getFlightById(int id)
	{
		//return flightRepo.findAll();
		return flightRepo.findById(id);
		
	}
	public List<Flight> findFlight(String toCity,String fromCity,Date departureDate)
	{
		return flightRepo.findFlight(toCity, fromCity, departureDate);
	}
	
}
