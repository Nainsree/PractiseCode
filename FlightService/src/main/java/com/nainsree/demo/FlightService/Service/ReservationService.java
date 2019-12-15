package com.nainsree.demo.FlightService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nainsree.demo.FlightService.Entity.Reservation;
import com.nainsree.demo.FlightService.Repositories.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepo;
	public Reservation saveReservation(Reservation res)
	{
		return reservationRepo.save(res);
	}
	public Reservation getReservationById(int id)
	{
		return reservationRepo.findById(id).get();
	}
}
