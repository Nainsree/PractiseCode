package com.nainsree.demo.FlightService.Entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CreateReservationRequest {

	private int flightid;
	@Size(min = 2,message = "Name should be of atleaset 2 character")
	private String passengerName;
	private String passengerEmail;
	private String passengerPhone;
	private String cardNo;
	private String expirationDate;
	private String securePin;
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getPassengerPhone() {
		return passengerPhone;
	}
	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getSecurePin() {
		return securePin;
	}
	public void setSecurePin(String securePin) {
		this.securePin = securePin;
	}
	
}
