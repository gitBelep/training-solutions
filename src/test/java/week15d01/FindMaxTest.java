package week15d01;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class FindMaxTest {

    @Test
    void testFindLastXToMaxY() {
        FindMax fm = new FindMax();

        Map<Double, Double> points = new HashMap<>();
        points.put(-0.5, -4.1);
        points.put( 0.0,  3.7);
        points.put(-2.0,  1.0);
        points.put( 2.0,  3.7);
        points.put( 3.5, -5.0);
        points.put( 1.1,  0.0);

        Map.Entry<Double, Double> result = fm.findLastXToMaxY(points);

        assertEquals(2.0, result.getKey());
        assertEquals(3.7, result.getValue());
    }

    @Test
    void testFindXValuesToMaxY() {
        FindMax fm = new FindMax();

        Map<Double, Double> points = new HashMap<>();
        points.put(-0.5, -4.1);
        points.put( 0.0,  3.7);
        points.put(-2.0,  1.0);
        points.put( 2.0,  3.7);
        points.put( 3.5, -5.0);
        points.put( 1.1,  0.0);

        Map<Double, Double> result = fm.findXValuesToMaxY(points);

        assertEquals(2, result.size());
        assertTrue(result.containsValue(3.7));
        assertTrue(result.keySet().contains(0.0));
    }
}