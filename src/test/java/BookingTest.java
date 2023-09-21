import org.example.Booking;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {
    private Booking booking;
    @Before
    public void before(){
        booking=new Booking(1,5);
    }
    @Test
    public void hasAttributes(){
        assertEquals(1,booking.getRoomNumber());
        assertEquals(5,booking.getNights());
    }
}
