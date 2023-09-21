import org.example.Bedroom;
import org.example.Guest;
import org.example.RoomType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BedroomTest {
    private Bedroom bedroom;
    private Guest guest;
    private Guest guest2;
    @Before
    public void before(){
        bedroom=new Bedroom(1,RoomType.DOUBLE);
        guest=new Guest("Kev");
        guest2=new Guest("Dev");
    }
    @Test
    public void hasAttributes(){
        assertEquals(2,bedroom.getCapacity());
        assertArrayEquals(new Guest[2],bedroom.getGuests());
        assertEquals(1,bedroom.getRoomNumber());
        assertEquals(RoomType.DOUBLE,bedroom.getRoomType());
    }
    //  ================================
    @Test
    public void canAddGuests(){
        boolean checkedIn=bedroom.addGuests(new Guest[]{guest});
        assertArrayEquals(new Guest[]{guest,null},bedroom.getGuests());
        assertEquals(true,checkedIn);
    }
    @Test
    public void canRemoveGuests(){
        bedroom.addGuests(new Guest[]{guest});
        bedroom.removeGuests();
        assertArrayEquals(new Guest[2],bedroom.getGuests());
    }
    @Test
    public void cantAddTooManyGuests(){
        boolean checkedIn=bedroom.addGuests(new Guest[]{guest,guest,guest});
        assertArrayEquals(new Guest[2],bedroom.getGuests());
        assertEquals(false,checkedIn);
    }
    @Test
    public void cantAddGuestsToOccupiedRoom(){
        boolean checkedIn=bedroom.addGuests(new Guest[]{guest});
        assertArrayEquals(new Guest[]{guest,null},bedroom.getGuests());
        assertEquals(true,checkedIn);

        checkedIn=bedroom.addGuests(new Guest[]{guest2}); // after attempting to add a new party
        assertArrayEquals(new Guest[]{guest,null},bedroom.getGuests()); // the original party should remain in the room
        assertEquals(false,checkedIn); // & bedroom.addGuests should return false
    }
}
