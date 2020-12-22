package week09d02;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibCalculatorTest {

    @Test
    public void fibCalcTest1(){
        FibCalculator f = new FibCalculator();
        assertEquals(0, f.sumEvens1(0));
        assertEquals(0, f.sumEvens1(1));
        assertEquals(2, f.sumEvens1(2));
        assertEquals(2, f.sumEvens1(3));
        assertEquals(2, f.sumEvens1(7));
        assertEquals(10, f.sumEvens1(8));
        assertEquals(10, f.sumEvens1(9));
        assertEquals(44, f.sumEvens1(37));
        assertEquals(10, f.sumEvens1(21));
    }

    @Test
    public void fibCalcTest2(){
        FibCalculator f = new FibCalculator();
        assertEquals(0, f.sumEvens1(0));
        assertEquals(0, f.sumEvens1(1));
        assertEquals(2, f.sumEvens1(2));
        assertEquals(2, f.sumEvens1(3));
        assertEquals(2, f.sumEvens1(7));
        assertEquals(10, f.sumEvens1(8));
        assertEquals(10, f.sumEvens1(9));
        assertEquals(44, f.sumEvens1(37));
        assertEquals(10, f.sumEvens1(21));
    }

    @Test
    public void fibCalcIllegalArg1(){
        FibCalculator f = new FibCalculator();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> f.sumEvens2(-3));
        assertEquals("Number is too small", ex.getMessage());
    }

}
