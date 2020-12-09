package week07d03;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberListTest {

    @Test
    public void numberListTest() {
        NumberList nrList = new NumberList();
        List<Integer> list1 = Arrays.asList(0, 0, 0, 2, 2, 1001, 1001, 1001);
        assertTrue(nrList.isIncreasing(list1));
    }

    @Test
    public void numberListMinusTest() {
        NumberList nrList = new NumberList();
        List<Integer> list3 = Arrays.asList(-90, -7, 0, 0, 1004);
        assertTrue(nrList.isIncreasing(list3));
    }

    @Test
    public void numberListFailureTest() {
        NumberList nrList = new NumberList();
        assertFalse(nrList.isIncreasing(Arrays.asList(0, 2, 70, -71, 1002)));
    }
}
