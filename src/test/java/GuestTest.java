import org.example.Guest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GuestTest {
    private Guest guest;
    @Before
    public void before(){
        guest=new Guest("Kev");
    }
    @Test
    public void hasName(){
        assertEquals("Kev",guest.getName());
    }
}
