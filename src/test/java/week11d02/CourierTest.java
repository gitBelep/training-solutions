package week11d02;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    public void createRide(){
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(1,1, 20));
        rides.add(new Ride(1,2, 40));
        rides.add(new Ride(1,3, 25));
        rides.add(new Ride(3,1, 2));
        rides.add(new Ride(5,1, 4));

        assertEquals(5, rides.size());
        assertEquals(25, rides.get(2).getKm());
    }

    @Test
    public void badRidesThrowException(){

        assertThrows(IllegalArgumentException.class, () -> new Ride(9,1, 20));
        assertThrows(IllegalArgumentException.class, () -> new Ride(2,1, 0));
    }

    @Test
    public void addRide(){
        Courier c = new Courier();
        c.addRide(new Ride(1,1, 20));
        c.addRide(new Ride(1,2, 40));
        c.addRide(new Ride(1,3, 25));
        c.addRide(new Ride(3,1, 2));
        c.addRide(new Ride(5,1, 4));

        assertEquals(5, c.getRides().size());
        assertEquals(25, c.getRides().get(2).getKm());
    }

    @Test
    public void notFirstRideThrowsEx(){
        Courier c = new Courier();

        assertThrows(IllegalArgumentException.class, () -> c.addRide(new Ride(1,3, 20)));
    }

    @Test
    public void addRideBadDayOrderThrowsEx(){
        Courier c = new Courier();

        c.addRide(new Ride(2,1, 20));

        assertThrows(IllegalArgumentException.class, () -> c.addRide(new Ride(1,1, 20)));
    }

    @Test
    public void noWork1(){
        Courier c = new Courier();
        c.addRide(new Ride(1,1, 20));
        c.addRide(new Ride(1,2, 40));
        c.addRide(new Ride(2,1, 25));
        c.addRide(new Ride(3,1, 2));
        c.addRide(new Ride(5,1, 4));

        assertEquals(4, c.noWorkOnDay());
    }

    @Test
    public void noWork2(){
        Courier c = new Courier();
        c.addRide(new Ride(1,1, 20));
        c.addRide(new Ride(1,2, 40));
        c.addRide(new Ride(2,1, 25));
        c.addRide(new Ride(3,1, 2));
        c.addRide(new Ride(5,1, 4));

        assertEquals(4, c.noWorkOnDaySecondRelease());
    }
}