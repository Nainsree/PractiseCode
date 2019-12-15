package com.nainsree.demo.FlightService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nainsree.demo.FlightService.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

}
