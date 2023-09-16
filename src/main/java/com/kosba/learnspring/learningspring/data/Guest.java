package com.kosba.learnspring.learningspring.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GUEST")
public class Guest {
	// GUEST_ID BIGSERIAL PRIMARY KEY,
	// FIRST_NAME VARCHAR(64),
	// LAST_NAME VARCHAR(64),
	// EMAIL_ADDRESS VARCHAR(64),
	// ADDRESS VARCHAR(64),
	// COUNTRY VARCHAR(32),
	// STATE VARCHAR(12),
	// PHONE_NUMBER VARCHAR(24)

	// vars
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GUEST_ID")
	private long guestId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "STATE")
	private String state;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	// constructor

	// getters and setters
	public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	// methods
	@Override
	public String toString() {
		return "Guest {" +
				"guestId: " + guestId +
				", firstName: " + firstName +
				", lastName: " + lastName +
				", email: " + emailAddress +
				", address: " + address +
				", country: " + country +
				", state: " + state +
				", phoneNumber: " + phoneNumber +
				"}";
	}

}
