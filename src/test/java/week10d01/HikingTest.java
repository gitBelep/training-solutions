package week10d01;
import org.junit.jupiter.api.Test;
import java.util.List;
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
        double[] heightDatas = {};
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Hiking().getPlusElevation(heightDatas));
        assertEquals("Values is empty", ex.getMessage());
    }

    @Test
    public void hikingList(){
        Hiking h = new Hiking();
        List<Double> heightDatas = List.of(100.0, 107d, 104.5, 110d, 90d, 100.4);
                                            //+7 +5.5 +10.4 = 22.9
        assertEquals(22.9, h.getPlusElevation(heightDatas), 0.0001);
    }

    @Test
    public void hikingNullDataThrowsEx2(){
        List<Double> heightDatas = List.of();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Hiking().getPlusElevation(heightDatas));
        assertEquals("Values is empty", ex.getMessage());
    }

}
