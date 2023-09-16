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
	private long roomId;

	@Column(name = "GUEST_ID")
	private long guestId;

	@Column(name = "RES_DATE")
	private Date reservationDate;

	// constructors

	// getters and setters
	public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

	// methods
	@Override
	public String toString() {
		return "Guest {" +
				"reservationId: " + reservationId +
				", roomId: " + roomId +
				", guestId: " + guestId +
				", date: " + reservationDate +
				"}";
	}

}
