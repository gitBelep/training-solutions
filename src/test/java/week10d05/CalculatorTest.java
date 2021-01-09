package week10d05;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void maxAndMin(){
        Calculator v = new Calculator();

        int[] arr = {5,1,-2,6,3,-1,6,5,8,9,6,8,7,5,5};
        //min=1,-2,3,-1 = 1;   max= 8,9,8,7 = 32;

        assertEquals(1, v.findMinMaxSum(arr)[0]);
        assertEquals(32, v.findMinMaxSum(arr)[1]);
    }

    @Test
    public void smallArray(){
        Calculator v = new Calculator();

        int[] arr = {5,9,-2};
        //min=12;   max= 12;

        assertEquals(12, v.findMinMaxSum(arr)[0]);
        assertEquals(12, v.findMinMaxSum(arr)[1]);
    }
}