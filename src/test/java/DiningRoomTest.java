import org.example.DiningRoom;
import org.example.Guest;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DiningRoomTest {
    private DiningRoom diningRoom;
    private Guest guest;
    private Guest guest2;
    private Guest guest3;
    @Before
    public void before(){
        diningRoom=new DiningRoom(50,"Dining Room");
        guest=new Guest("Kev");
        guest2=new Guest("Dev");
        guest3=new Guest("Mev");
    }
    @Test
    public void hasAttributes(){
        assertEquals(50,diningRoom.getCapacity());
        assertArrayEquals(new Guest[50],diningRoom.getGuests());
        assertEquals("Dining Room",diningRoom.getName());
    }
    //  ================================
    @Test
    public void canAddGuests(){
        boolean checkedIn=diningRoom.addGuests(new Guest[]{guest}); // after adding one guest
        Guest[] expected=new Guest[50];
        expected[0]=guest; // we expect an empty array of size 10 where the first element is guest
        assertArrayEquals(expected,diningRoom.getGuests());
        assertEquals(true,checkedIn);
    }
    @Test
    public void cantAddTooManyGuestsAtOnce(){
        Guest[] party=new Guest[51]; // dining room has a capacity of 50
        Arrays.fill(party,guest);
        boolean checkedIn=diningRoom.addGuests(party);
        assertArrayEquals(new Guest[50],diningRoom.getGuests());
        assertEquals(false,checkedIn);
    }
    @Test
    public void cantAddTooManyGuestsSeparately(){
        Guest[] party=new Guest[30];
        Arrays.fill(party,guest);
        boolean checkedIn=diningRoom.addGuests(party);
        assertEquals(true,checkedIn);

        Guest[] expected=new Guest[50];
        Arrays.fill(expected,0,30,guest); // expecting 30 guest then 20 null
        assertArrayEquals(expected,diningRoom.getGuests());

        Guest[] party2=new Guest[30]; // 2 parties of 30 is over the capacity of 50
        Arrays.fill(party2,guest2);
        checkedIn=diningRoom.addGuests(party2);
        assertEquals(false,checkedIn);

        assertArrayEquals(expected,diningRoom.getGuests()); // expecting same as before
    }
    @Test
    public void canAddGuestsToOccupiedRoomIfSpace(){
        boolean checkedIn=diningRoom.addGuests(new Guest[]{guest,guest,guest,guest});
        Guest[] expected=new Guest[50];
        expected[0]=guest;
        expected[1]=guest;
        expected[2]=guest;
        expected[3]=guest;
        assertArrayEquals(expected,diningRoom.getGuests());
        assertEquals(true,checkedIn);

        checkedIn=diningRoom.addGuests(new Guest[]{guest2,guest2,guest2}); // after attempting to add a new party
        expected[4]=guest2;
        expected[5]=guest2;
        expected[6]=guest2;
        assertArrayEquals(expected,diningRoom.getGuests()); // both parties should be in the room
        assertEquals(true,checkedIn); // & diningRoom.addGuests should return true
    }
    @Test
    public void canRemoveAllGuests(){
        diningRoom.addGuests(new Guest[]{guest});
        diningRoom.removeGuests();
        assertArrayEquals(new Guest[50],diningRoom.getGuests());
    }
    @Test
    public void canRemoveSpecificGuests(){
        diningRoom.addGuests(new Guest[]{guest,guest,guest2,guest3});
        diningRoom.removeGuests(new Guest[]{guest,guest2});
        Guest[] expected=new Guest[50];
        expected[0]=guest3; // remaining guests should be moved to start of array for easy adding
        assertArrayEquals(expected,diningRoom.getGuests());
    }
}