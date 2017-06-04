package com.example.akashsalow.project.Bean;

import java.io.Serializable;

/**
 * Created by Akash Salow on 03-06-2017.
 * First Name(Edit Text)
 Last Name(Edit Text)
 Phone Number(Ph No field)
 Address(TextArea)
 Number of Guest(Number field)
 Total Number of rooms(Number field)
 Book Rooms(Button)

 */

public class Room implements Serializable {

    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String address;
    private Integer noOfGuests;
    private Integer totalNoOfRooms;

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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(Integer noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public Integer getTotalNoOfRooms() {
        return totalNoOfRooms;
    }

    public void setTotalNoOfRooms(Integer totalNoOfRooms) {
        this.totalNoOfRooms = totalNoOfRooms;
    }

    @Override
    public String toString() {
        return "Room{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", noOfGuests=" + noOfGuests +
                ", totalNoOfRooms=" + totalNoOfRooms +
                '}';
    }
}
