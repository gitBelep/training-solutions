package week08d01;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotTest {

    @Test
    public void robotMovesTest(){

        Robot r = new Robot();

        assertEquals("-1,-1", r.move("LBbFjJBL").toString());
    }

    @Test
    public void robotIllegalArgument(){

        Robot r = new Robot();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> r.move("LBbFjJBkL").toString());
        assertEquals("Non existing direction", ex.getMessage());
    }
}
