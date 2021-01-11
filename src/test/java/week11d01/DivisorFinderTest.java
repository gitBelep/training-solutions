package week11d01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    public void divisorFinder() {
        DivisorFinder d = new DivisorFinder();
        assertEquals(3, d.findDivisors(12375));
        assertEquals(2, d.findDivisors(123));
        assertEquals(2, d.findDivisors(1001));

    }
}