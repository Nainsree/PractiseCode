package com.nainsree.demo.FlightService.Controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nainsree.demo.FlightService.CustomExceptions.FlightCustomRuntimeException;
import com.nainsree.demo.FlightService.Entity.CreateReservationRequest;
import com.nainsree.demo.FlightService.Entity.Flight;
import com.nainsree.demo.FlightService.Entity.Passenger;
import com.nainsree.demo.FlightService.Entity.Reservation;
import com.nainsree.demo.FlightService.Entity.UpdatedReservation;
import com.nainsree.demo.FlightService.Repositories.ReservationRepository;
import com.nainsree.demo.FlightService.Service.FlightService;
import com.nainsree.demo.FlightService.Service.PassengerService;
import com.nainsree.demo.FlightService.Service.ReservationService;

@RestController
@Validated
@CrossOrigin
public class FlightRestController {

	@Autowired
	FlightService flightService;

	@Autowired
	PassengerService passengerService;

	@Autowired
	ReservationService reservationService;

	@GetMapping("/FindFlights")
	public List<Flight> getFlightList() {
		return flightService.getFlightList();
	}

	@GetMapping("/FindFlights/{id}")
	public Optional<Flight> getFlightList(@PathVariable("id")@Min(value=1,message="Minimum value is required") int id) {
		if (!flightService.getFlightById(id).isPresent())
			throw new FlightCustomRuntimeException("Flight id not found");
		return flightService.getFlightById(id);

	}

	@PostMapping("/savereservation")
	@Transactional
	public ResponseEntity saveReservation(@Valid @RequestBody CreateReservationRequest request) {
		Flight flight = flightService.getFlightById(request.getFlightid()).get();
		Passenger passenger = new Passenger();
		passenger.setName(request.getPassengerName());
		passenger.setEmailId(request.getPassengerEmail());
		passenger.setPhoneNo(request.getPassengerPhone());
		Passenger savedPassenger = passengerService.savePassengerDetails(passenger);
		Reservation res = new Reservation();
		res.setFlight(flight);

		res.setPassenger(savedPassenger);
		res.setCheckedIn(false);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(res.getId())
				.toUri();
		// return reservationService.saveReservation(res);
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") int id) {
		return reservationService.getReservationById(id);
	}

	@PutMapping("/savereservation")
	public Reservation updateReservation(@RequestBody UpdatedReservation reservation) {
		Reservation reservationById = reservationService.getReservationById(reservation.getId());
		reservationById.setCheckedIn(reservation.isCheckIn());
		reservationById.setNumberOfBags(reservation.getNumberOfBags());
		return reservationService.saveReservation(reservationById);

	}

	@GetMapping("/FilterFlights")
	public List<Flight> filterFlight(
			@RequestParam("from") @Size(min = 3, message = "from is wrong") String fromCity,
			@RequestParam("depdate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date departureDate,
			@RequestParam("to") String toCity) {
		return flightService.findFlight(toCity, fromCity, departureDate);
	}

	/*
	 * @GetMapping("/FilterFlights") public ResponseEntity<List<Flight>>
	 * filterFlight(@RequestParam("from")@Size(min=3, message="from is wrong")String
	 * fromCity, @RequestParam("depdate")@DateTimeFormat(pattern="MM-dd-yyyy")Date
	 * departureDate,@RequestParam("to") String toCity) { return new
	 * ResponseEntity(flightService.findFlight(toCity, fromCity,
	 * departureDate),HttpStatus.ACCEPTED); }
	 */
}
