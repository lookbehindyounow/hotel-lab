package org.example;
import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    public Hotel(String _name, ArrayList<Bedroom> _bedrooms, ArrayList<ConferenceRoom> _conferenceRooms){
        this.name=_name;
        this.bedrooms=_bedrooms;
        this.conferenceRooms=_conferenceRooms;
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

    public boolean checkIn(Guest[] guests, int roomNumber){
        return bedrooms.get(roomNumber-1).addGuests(guests);
    }
    public void checkOut(int roomNumber){
        bedrooms.get(roomNumber-1).removeGuests();
    }
}
