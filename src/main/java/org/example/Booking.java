package org.example;

public class Booking {
    private int roomNumber;
    private int nights;
    public Booking(int _roomNumber, int _nights){
        this.roomNumber=_roomNumber;
        this.nights=_nights;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public int getNights(){
        return nights;
    }
}
