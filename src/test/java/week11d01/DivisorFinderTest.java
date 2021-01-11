package week11d01;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    public void divisorFinder() {
        DivisorFinder d = new DivisorFinder();

        assertEquals(3, d.findDivisors(12375));  //1,3,5
        assertEquals(2, d.findDivisors(-123));   //1,3
        assertEquals(2, d.findDivisors(-1001));  //1,1
        assertEquals(1, d.findDivisors(7));
        assertEquals(1, d.findDivisors(-7));
    }

    @Test
    public void divisorFinder2() {
        DivisorFinder d = new DivisorFinder();

        assertEquals(3, d.findDivisors2(12375));
        assertEquals(2, d.findDivisors2(-123));
        assertEquals(2, d.findDivisors2(-1001));
        assertEquals(1, d.findDivisors2(7));
        assertEquals(1, d.findDivisors2(-7));
    }

}