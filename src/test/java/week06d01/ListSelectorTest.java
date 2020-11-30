package week06d01;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListSelectorTest {

    @Test
    public void getSecondListTest(){
        List<String> probe = new ArrayList<>();
        probe.add("AB");
        probe.add("cd");
        probe.add("Ef");
        probe.add("7f");
        probe.add("58");
        ListSelector ls = new ListSelector();

        assertEquals("[AB, Ef, 58]", ls.getEverySecond(probe));
    }

    @Test
    public void getSecondWithNull(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new ListSelector().getEverySecond(null);
        });
        assertEquals("Null Lista", ex.getMessage());

    }

    @Test
    public void getSecondWithEmpty(){
        List<String> probe = new ArrayList<>();
        ListSelector ls = new ListSelector();

        assertEquals("[]", ls.getEverySecond(probe));
    }
}
