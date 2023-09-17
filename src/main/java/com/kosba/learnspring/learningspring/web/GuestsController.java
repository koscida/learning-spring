package com.kosba.learnspring.learningspring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kosba.learnspring.learningspring.business.ReservationService;
import com.kosba.learnspring.learningspring.data.Guest;

@Controller
@RequestMapping("/guests")
public class GuestsController {
	
	private final ReservationService reservationService;

	// constructor
	public GuestsController(ReservationService guestService) {
		this.reservationService = guestService;
	}

	// methods
	@RequestMapping(method = RequestMethod.GET)
	public String getGuests(Model model) {
		List<Guest> guests = this.reservationService.getGuests();

		model.addAttribute("guests", guests);

		return "guests";
	}


}
