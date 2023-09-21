package org.example;
import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Booking> bookings;
    public Hotel(String _name, ArrayList<Bedroom> _bedrooms, ArrayList<ConferenceRoom> _conferenceRooms){
        this.name=_name;
        this.bedrooms=_bedrooms;
        this.conferenceRooms=_conferenceRooms;
        this.bookings=new ArrayList<Booking>();
    }
    public String getName(){
        return name;
    }
    public ArrayList<Bedroom> getBedrooms(){
        return bedrooms;
    }
    public ArrayList<ConferenceRoom> getConferenceRooms(){
        return conferenceRooms;
    }

    public ArrayList<Booking> getBookings(){
        return bookings;
    }

    public boolean checkIn(Guest[] guests, int roomNumber){ // returns boolean true if successful
        return bedrooms.get(roomNumber-1).addGuests(guests);
    }
    public void checkOut(int roomNumber){
        bedrooms.get(roomNumber-1).removeGuests();
    }
    public double book(int roomNumber, int nights){
        bookings.add(new Booking(roomNumber,nights));
        return nights*bedrooms.get(roomNumber-1).getRate();
    }
}
