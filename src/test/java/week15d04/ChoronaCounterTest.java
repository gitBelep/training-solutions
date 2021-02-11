package week15d04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

class ChoronaCounterTest {

    @Test
    void choronaFalls() {
        ChoronaCounter cc = new ChoronaCounter();
        List<String> result = cc.choronaCases();
        System.out.println(result);
        assertEquals("2020-48", result.get(0).substring(0, 7));
        assertEquals("2020-49", result.get(1).substring(0, 7));
        assertEquals("2020-46", result.get(2).substring(0, 7));
    }
}