package org.example;

public abstract class Room {
    private int capacity;
    private Guest[] guests;
    public Room(int _capacity){
        this.capacity=_capacity;
        this.guests=new Guest[capacity];
    }
    public int getCapacity(){
        return capacity;
    }
    public Guest[] getGuests(){
        return guests;
    }

    public boolean addGuests(Guest[] _guests){
        if (_guests.length<=capacity&&this.guests[0]==null){
            System.arraycopy(_guests,0,this.guests,0,_guests.length);
            return true;
        } else{ // if there's too many guests or if another party already checked in
            return false;
        }
    }
    public void removeGuests(){
        guests=new Guest[capacity];
    }
}
