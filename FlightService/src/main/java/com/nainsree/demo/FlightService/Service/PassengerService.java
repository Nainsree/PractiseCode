package com.nainsree.demo.FlightService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nainsree.demo.FlightService.Entity.Passenger;
import com.nainsree.demo.FlightService.Repositories.PassengerRepository;

@Service
public class PassengerService {

	@Autowired
	PassengerRepository passengerRepo;
	
	public Passenger savePassengerDetails(Passenger p)
	{
		return passengerRepo.save(p);
	}
	
}
