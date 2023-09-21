package org.example;

public enum RoomType {
    SINGLE(1),
    DOUBLE(2);
    private final int capacity;
    RoomType(int _capacity){
        this.capacity=_capacity;
    }
    public int getCapacity(){
        return capacity;
    }
}
