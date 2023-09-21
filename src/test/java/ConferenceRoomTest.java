import org.example.ConferenceRoom;
import org.example.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {
    private ConferenceRoom conferenceRoom;
    @Before
    public void before(){
        conferenceRoom=new ConferenceRoom(10,"Conference Room");
    }
    @Test
    public void hasAttributes(){
        assertEquals(10,conferenceRoom.getCapacity());
        assertArrayEquals(new Guest[10],conferenceRoom.getGuests());
        assertEquals("Conference Room",conferenceRoom.getName());
    }
}
