import org.example.Bedroom;
import org.example.Guest;
import org.example.RoomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BedroomTest {
    private Bedroom bedroom;
    @Before
    public void before(){
        bedroom=new Bedroom(1,RoomType.DOUBLE);
    }
    @Test
    public void hasAttributes(){
        assertEquals(2,bedroom.getCapacity());
        assertArrayEquals(new Guest[2],bedroom.getGuests());
        assertEquals(1,bedroom.getRoomNumber());
        assertEquals(RoomType.DOUBLE,bedroom.getRoomType());
    }
}
