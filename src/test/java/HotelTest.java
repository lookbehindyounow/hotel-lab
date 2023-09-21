import org.example.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HotelTest {
    private Hotel hotel;
    private Bedroom bedroom;
    private Bedroom bedroom2;
    private ConferenceRoom conferenceRoom;
    private Guest guest;
    private Guest guest2;
    @Before
    public void before(){
        bedroom=new Bedroom(1, RoomType.DOUBLE);
        bedroom2=new Bedroom(2, RoomType.SINGLE);
        conferenceRoom=new ConferenceRoom(10,"Conference Room");
        hotel=new Hotel("The Grand Hotel", new ArrayList<Bedroom>(Arrays.asList(bedroom,bedroom2)), new ArrayList<ConferenceRoom>(Arrays.asList(conferenceRoom)));
        guest=new Guest("Kev");
        guest2=new Guest("Dev");
    }
    @Test
    public void hasAttributes(){
        assertEquals("The Grand Hotel",hotel.getName());
        assertEquals(new ArrayList<Bedroom>(Arrays.asList(bedroom,bedroom2)),hotel.getBedrooms());
        assertEquals(new ArrayList<ConferenceRoom>(Arrays.asList(conferenceRoom)),hotel.getConferenceRooms());
    }

    @Test
    public void canCheckIn(){
        assertArrayEquals(new Guest[1],bedroom2.getGuests());
        boolean checkedIn=hotel.checkIn(new Guest[]{guest},2);
        assertArrayEquals(new Guest[]{guest},bedroom2.getGuests());
        assertEquals(true,checkedIn);
    }
    @Test
    public void canCheckOut(){
        hotel.checkIn(new Guest[]{guest},2);
        hotel.checkOut(2);
        assertArrayEquals(new Guest[1],bedroom2.getGuests());
    }
    @Test
    public void cantCheckInTooManyGuests(){
        boolean checkedIn=hotel.checkIn(new Guest[]{guest,guest2},2);
        assertArrayEquals(new Guest[1],bedroom2.getGuests());
        assertEquals(false,checkedIn);

        checkedIn=hotel.checkIn(new Guest[]{guest,guest,guest2},1);
        assertArrayEquals(new Guest[2],bedroom.getGuests());
        assertEquals(false,checkedIn);
    }
    @Test
    public void cantCheckInOccupiedRoom(){
        boolean checkedIn=hotel.checkIn(new Guest[]{guest},1);
        assertArrayEquals(new Guest[]{guest,null},bedroom.getGuests());
        assertEquals(true,checkedIn);

        checkedIn=hotel.checkIn(new Guest[]{guest2},1);
        assertArrayEquals(new Guest[]{guest,null},bedroom.getGuests());
        assertEquals(false,checkedIn);
    }
}