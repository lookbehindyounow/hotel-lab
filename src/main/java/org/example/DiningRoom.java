package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class DiningRoom extends ConferenceRoom {
    public DiningRoom(int _capacity, String _name){
        super(_capacity, _name);
    }

    @Override
    public double getRate(){
        return 0;
    }
    @Override
    public boolean addGuests(Guest[] newGuests){
        Guest[] currentGuests=this.getGuests();
        int spaces=0;
        for (Guest guest: currentGuests){
            if (guest==null){
                spaces++;
            }
        }
        if (newGuests.length<=spaces){
            System.arraycopy(newGuests,0,currentGuests,this.getCapacity()-spaces,newGuests.length);
            return true;
        } else{ // if there's more guests than spaces available
            return false;
        }
    }
    // @Override was giving me red squigglys here because Room.removeGuests takes no arguments, so this
    // is a new method altogether, the original just removes all guests (maybe the kitchen's closed)
    public void removeGuests(Guest[] guestsToRemove){
        Guest[] currentGuests=this.getGuests();
        ArrayList<Guest> newGuests=new ArrayList<>();
        for (Guest guest: currentGuests){
            if (! (Arrays.asList(guestsToRemove).contains(guest) || guest==null) ){
                newGuests.add(guest);
            }
        }
        this.removeGuests();
        System.out.println(newGuests.toArray()[0].getName()); //the fuck
//        this.addGuests(newGuests.toArray());
    }
}
