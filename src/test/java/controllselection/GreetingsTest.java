package controllselection;

import controllselection.greetings.Greetings;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingsTest {
    @Test
    public void testSayGreeting(){
        Greetings g = new Greetings();
        assertEquals("Good night",g.sayGreeting(3,30));
        assertEquals("Good night",g.sayGreeting(4,59));
        assertEquals("Good night",g.sayGreeting(0,1));
        assertEquals("Good morning",g.sayGreeting(5,1));
        assertEquals("Good morning",g.sayGreeting(8,59));


    }
}
