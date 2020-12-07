package week07d01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathAlgorithmsTest {
    @Test
    public void checkIS_PRIM(){
        assertFalse(MathAlgorithms.IS_PRIME(1));
        assertTrue(MathAlgorithms.IS_PRIME(2));
        assertTrue(MathAlgorithms.IS_PRIME_B(3));
        assertFalse(MathAlgorithms.IS_PRIME_B(4));
        assertTrue(MathAlgorithms.IS_PRIME(101));
        assertFalse(MathAlgorithms.IS_PRIME(1001));
    }

    @Test
    public void checkIS_PRIM_B(){
        assertFalse(MathAlgorithms.IS_PRIME(1));
        assertTrue(MathAlgorithms.IS_PRIME(2));
        assertTrue(MathAlgorithms.IS_PRIME_B(3));
        assertFalse(MathAlgorithms.IS_PRIME_B(4));
        assertTrue(MathAlgorithms.IS_PRIME(101));
        assertFalse(MathAlgorithms.IS_PRIME(1001));
    }
}
