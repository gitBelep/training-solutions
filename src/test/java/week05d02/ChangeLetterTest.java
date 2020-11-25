package week05d02;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {

    @Test
    public void testChangeWowel() {
        ChangeLetter c = new ChangeLetter();

        assertEquals("*lb*rl*t* t*k*rf*r*g*p", c.changeVowels("Alberleti tukorfurogep"));
    }

    @Test
    public void testChangeWowel2() {
        ChangeLetter c = new ChangeLetter();

        assertEquals("*lb*rl*t* t*k*rf*r*g*p", c.changeVowels2("Alberleti tukorfurogep"));
    }
}
