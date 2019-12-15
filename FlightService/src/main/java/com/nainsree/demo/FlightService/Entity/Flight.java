package com.nainsree.demo.FlightService.Entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.sql.Date;
@Entity
@Table(name="flight")
public class Flight extends AbstractEntity {

	
	private String flightNumber;
	private String airLine;
	private String arrivingCity;
	private String departureCity;
	private Date departureDate;
	private Timestamp expectedDepartureTime;
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirLine() {
		return airLine;
	}
	public void setAirLine(String airLine) {
		this.airLine = airLine;
	}
	public String getArrivingCity() {
		return arrivingCity;
	}
	public void setArrivingCity(String arrivingCity) {
		this.arrivingCity = arrivingCity;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Timestamp getExpectedDepartureTime() {
		return expectedDepartureTime;
	}
	public void setExpectedDepartureTime(Timestamp expectedDepartureTime) {
		this.expectedDepartureTime = expectedDepartureTime;
	}
}
