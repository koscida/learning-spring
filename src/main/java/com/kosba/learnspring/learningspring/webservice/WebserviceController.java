package com.kosba.learnspring.learningspring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kosba.learnspring.learningspring.business.ReservationService;
import com.kosba.learnspring.learningspring.business.RoomReservation;
import com.kosba.learnspring.learningspring.data.Guest;
import com.kosba.learnspring.learningspring.data.Room;
import com.kosba.learnspring.learningspring.util.DateUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api")
public class WebserviceController {

	private final DateUtils dateUtils;
	private final ReservationService reservationService;


	public WebserviceController(DateUtils dateUtils, ReservationService reservationService) {
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
	}

	//
	// Reservations

	// Get
	@RequestMapping(path="/reservations", method = RequestMethod.GET)
	public List<RoomReservation> getReservations(@RequestParam(value="date", required = false) String dateString) {
		Date date = this.dateUtils.createDateFromDateString(dateString);
		
		return this.reservationService.getRoomReservationsForDate(date);
	}

	//
	// Guests

	// Get
	@GetMapping("/guests")
	public List<Guest> getGuests() {
		return this.reservationService.getGuests();
	}
	
	// Post
	@PostMapping(value="/guests")
	@ResponseStatus(HttpStatus.CREATED)
	public void addGuest(@RequestBody Guest guest) {
		this.reservationService.addGuest(guest);
	}

	//
	// Rooms
	
	// Get
	@RequestMapping(value="/rooms", method=RequestMethod.GET)
	public List<Room> getRooms() {
		return this.reservationService.getRooms();
	}
	
	
}
