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
}

