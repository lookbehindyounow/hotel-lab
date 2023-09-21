package org.example;

public class Bedroom extends Room{
    private int roomNumber;
    private RoomType roomType;
    public Bedroom(int _roomNumber, RoomType _roomType){
        super(_roomType.getCapacity());
        this.roomNumber=_roomNumber;
        this.roomType=_roomType;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public RoomType getRoomType(){
        return roomType;
    }
}
