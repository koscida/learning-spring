package com.kosba.learnspring.learningspring.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.kosba.learnspring.learningspring.data.Guest;
import com.kosba.learnspring.learningspring.data.GuestRepository;
import com.kosba.learnspring.learningspring.data.Reservation;
import com.kosba.learnspring.learningspring.data.ReservationRepository;
import com.kosba.learnspring.learningspring.data.Room;
import com.kosba.learnspring.learningspring.data.RoomRepository;

@Service
public class ReservationService {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

	// constructor

	public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}

	// methods

	// 
	// Reservations - Get

    public List<RoomReservation> getRoomReservationsForDate(Date date) {
		Map<Long, RoomReservation> roomReservationMap = new HashMap();

        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });

        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }

        roomReservations.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if (o1.getRoomName().equals(o2.getRoomName())) {
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomName().compareTo(o2.getRoomName());
            }
        });

        return roomReservations;
    }

	// 
	// Guest
	
	// Get

	public List<Guest> getGuests() {
		Iterable<Guest> guests = this.guestRepository.findAll();

		List<Guest> guestList = new ArrayList<>();

		guests.forEach(guest -> {guestList.add(guest);});

		guestList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                if (o1.getLastName().equals(o2.getLastName())) {
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
		
		return guestList;
	}

	// Add
	public void addGuest(Guest guest) {
		if(guest == null) {
			throw new RuntimeException("Guests cannot be null");
		}
		this.guestRepository.save(guest);
	}

	// 
	// Room - Get

	public List<Room> getRooms() {
		Iterable<Room> rooms = this.roomRepository.findAll();

		List<Room> roomList = new ArrayList<>();

		rooms.forEach(room -> {roomList.add(room);});

		roomList.sort(new Comparator<Room>() {
			@Override
			public int compare(Room r1, Room r2) {
				if(r1.getName().equals(r2.getName())) {
					return r1.getRoomNumber().compareTo(r2.getRoomNumber());
				}
				return r1.getName().compareTo(r2.getName());
			}
		});

		return roomList;
	}
}

