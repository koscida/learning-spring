package com.kosba.learnspring.learningspring.data;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
	// RESERVATION_ID BIGSERIAL PRIMARY KEY,
	// ROOM_ID BIGINT NOT NULL,
	// GUEST_ID BIGINT NOT NULL,
	// RES_DATE DATE

	// vars
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESERVATION_ID")
	private long reservationId;

	@Column(name = "ROOM_ID")
	private int roomId;

	@Column(name = "GUEST_ID")
	private int guestId;

	@Column(name = "RES_DATE")
	private Date date;

	// constructors

	// getters and setters
	public long getReservationId() {
		return this.reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public int getRoomId() {
		return this.roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getGuestId() {
		return this.guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// methods
	@Override
	public String toString() {
		return "Guest {" +
				"reservationId: " + reservationId +
				", roomId: " + roomId +
				", guestId: " + guestId +
				", date: " + date +
				"}";
	}

}
