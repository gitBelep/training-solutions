package week12d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {
//method overload, csak egyik használja az Attributum listát,
//így mehet a Test ugyanazon az objektumon is

    @Test
    void findTheSmallestUnic() {
        NumberStat ns = new NumberStat();
        // [-6, -6, 0, 0, 0, 1, 1, 2, 3, 3, 4]
        assertEquals(2, ns.findTheSmallestUnique(Arrays.asList(3,2,4,1,0,-6,0,0,-6,3,1)));
    }

    @Test
    void findTheSmallestUnicFromFile() {
        NumberStat ns = new NumberStat();
        ns.fillList("C:\\training\\training-solutions\\src\\main\\resources\\week12d03hoz.txt");
//        1,1,4
//        2,3,5
//        2,2,5
        assertEquals(3, ns.findTheSmallestUnique() );
    }

}