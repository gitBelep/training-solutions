package week07d02;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumTest {
    @Test
    public void sumTest(){
        DigitSum d = new DigitSum();
        assertEquals(9, d.sumOfDigits(234));
        assertEquals(16, d.sumOfDigits(934));
        assertEquals(2, d.sumOfDigits(200000));
    }

    @Test
    public void sumTestMuchBetterIdea(){
        assertEquals(9, DigitSum.sumOfDigitsMuchBetterIdea(234));
        assertEquals(16, DigitSum.sumOfDigitsMuchBetterIdea(934));
        assertEquals(2, DigitSum.sumOfDigitsMuchBetterIdea(200000));
    }
}

