package org.example;

public class ConferenceRoom extends Room {
    private String name;
    public ConferenceRoom(int _capacity, String _name){
        super(_capacity);
        this.name=_name;
    }
    public String getName(){
        return name;
    }
}
