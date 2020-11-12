package introjunit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest {
    @Test
    public void testGreeting() {
        //Given
        Gentleman test1 = new Gentleman();
        //When
        String ez = test1.sayHello("John Doe");
        //Then
        assertEquals("Hello John Doe", ez);
    }
    @Test
    public void testNull(){
        //Given
        Gentleman testNull = new Gentleman();
        String n = null;
        //When
        String ez2 = testNull.sayHello(n);
        //Then
        assertEquals("Hello Anonymous", ez2);
    }
}
