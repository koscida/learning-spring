package com.kosba.learnspring.learningspring.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "ROOM")
public class Room {
	// ROOM_ID BIGSERIAL PRIMARY KEY,
	// NAME VARCHAR(16) NOT NULL,
	// ROOM_NUMBER CHAR(2) NOT NULL UNIQUE,
	// BED_INFO CHAR(2) NOT NULL

	// vars
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROOM_ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ROOM_NUMBER")
	private String roomNumber;

	@Column(name = "BED_INFO")
	private String bedInfo;

	// constructor

	// getters and setters
	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

	// methods
	@Override
	public String toString() {
		return "Room {" +
				"id: " + id +
				", name: " + name +
				", roomNumber: " + roomNumber +
				", bedInfo: " + bedInfo +
				"}";
	}

}
