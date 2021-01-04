package week10d01;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HikingTest {

    @Test
    public void hiking(){
        Hiking h = new Hiking();
        double[] heightDatas = {100.0, 107, 104.5, 110, 90, 100.4};
                                   //+7 +5.5 +10.4 = 22.9
        assertEquals(22.9, h.getPlusElevation(heightDatas), 0.0001);
    }

    @Test
    public void hikingNullDataThrowsEx(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Hiking().getPlusElevation(null));
        assertEquals("Values is empty", ex.getMessage());
    }
}
