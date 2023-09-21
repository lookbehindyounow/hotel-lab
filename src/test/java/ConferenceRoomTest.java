import org.example.ConferenceRoom;
import org.example.Guest;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {
    private ConferenceRoom conferenceRoom;
    private Guest guest;
    private Guest guest2;
    @Before
    public void before(){
        conferenceRoom=new ConferenceRoom(10,"Conference Room");
        guest=new Guest("Kev");
        guest2=new Guest("Dev");
    }
    @Test
    public void hasAttributes(){
        assertEquals(10,conferenceRoom.getCapacity());
        assertArrayEquals(new Guest[10],conferenceRoom.getGuests());
        assertEquals("Conference Room",conferenceRoom.getName());
    }

    @Test
    public void canAddGuests(){
        boolean checkedIn=conferenceRoom.addGuests(new Guest[]{guest}); // after adding one guest
        Guest[] expected=new Guest[10];
        expected[0]=guest; // we expect an empty array of size 10 where the first element is guest
        assertArrayEquals(expected,conferenceRoom.getGuests());
        assertEquals(true,checkedIn);
    }
    @Test
    public void canRemoveGuests(){
        conferenceRoom.addGuests(new Guest[]{guest});
        conferenceRoom.removeGuests();
        assertArrayEquals(new Guest[10],conferenceRoom.getGuests());
    }
    @Test
    public void cantAddTooManyGuests(){
        Guest[] party=new Guest[11]; // conference room has a capacity of 10
        Arrays.fill(party,guest);
        boolean checkedIn=conferenceRoom.addGuests(party);
        assertArrayEquals(new Guest[10],conferenceRoom.getGuests());
        assertEquals(false,checkedIn);
    }
    @Test
    public void cantAddGuestsToOccupiedRoom(){
        boolean checkedIn=conferenceRoom.addGuests(new Guest[]{guest});
        Guest[] expected=new Guest[10];
        expected[0]=guest;
        assertArrayEquals(expected,conferenceRoom.getGuests());
        assertEquals(true,checkedIn);

        checkedIn=conferenceRoom.addGuests(new Guest[]{guest2}); // after attempting to add a new party
        assertArrayEquals(expected,conferenceRoom.getGuests()); // the original party should remain in the room
        assertEquals(false,checkedIn); // & conferenceRoom.addGuests should return false
    }
}
