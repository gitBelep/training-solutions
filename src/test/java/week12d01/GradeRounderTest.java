package week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    @Test
    void roundGrades() {
        GradeRounder gr = new GradeRounder();
        int[] testNumbers = new int[]{3, 39, 40, 41, 42, 43, 44, 45, 46};

        assertEquals("[3, 39, 40, 41, 42, 45, 45, 45, 46]", Arrays.toString(gr.roundGrades(testNumbers)) );
    }

    @Test
    void throwExWhenNrIsGreaterThen100OrSmallerThanZero() {
        GradeRounder gr = new GradeRounder();
        int[] testNumbersHundred = new int[]{3, 41, 446, 5};
        int[] testNumbersZero = new int[]{3, 41, -5, 5};

        assertThrows(IllegalArgumentException.class, () -> gr.roundGrades(testNumbersHundred));
        assertThrows(IllegalArgumentException.class, () -> gr.roundGrades(testNumbersZero));
    }

}