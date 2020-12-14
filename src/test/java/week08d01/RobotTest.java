package week08d01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    @Test
    public void robotTest(){

        Robot r = new Robot();

        assertEquals("X=-1, Y=-1", r.move("LBBFJJBL"));

    }
}
