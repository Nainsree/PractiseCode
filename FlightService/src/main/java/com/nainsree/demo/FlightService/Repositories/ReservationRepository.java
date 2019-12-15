package com.nainsree.demo.FlightService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nainsree.demo.FlightService.Entity.Passenger;
import com.nainsree.demo.FlightService.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

}
