package week08d05;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathAlgorithmsTest {

    @Test
    public void lnkoTest(){
        MathAlgorithms ma = new MathAlgorithms();

        assertEquals(8, ma.greatestCommonDivisor(24,32));
        assertEquals(77, ma.greatestCommonDivisor(77,1001));
        assertEquals(1, ma.greatestCommonDivisor(24,10001));
    }

    @Test
    public void lnkoEuklidesTest(){
        MathAlgorithms ma = new MathAlgorithms();

        assertEquals(8, ma.greatestCommonDivisorEuclidean(24,32));
        assertEquals(77, ma.greatestCommonDivisorEuclidean(77,1001));
        assertEquals(1, ma.greatestCommonDivisorEuclidean(24,10001));
    }
}
