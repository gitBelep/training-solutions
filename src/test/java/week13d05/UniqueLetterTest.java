package week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueLetterTest {

    @Test
    void countUniqueLetter() {
        UniqueLetter u = new UniqueLetter();
        assertEquals(5, u.countUniqueLetters(" aBc *\n\"Aaf66,(gcc"));
        assertEquals(0, u.countUniqueLetters("* Á_Éő ö(9*4)^662.7é"));
    }
}