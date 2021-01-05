package week10d02;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void checkGetMaxIndex() {
        MaxTravel m = new MaxTravel();
        List<Integer> stoplist = List.of(9,12,12,0,3,4,4,12,9);

        assertEquals(12, m.getMaxIndex(stoplist));
    }

    @Test
    void checkGetMaxIndex_Szebb() {
        MaxTravel m = new MaxTravel();
        List<Integer> stoplist = List.of(9,12,12,0,3,4,4,12,9);

        assertEquals(12, m.getMaxIndex_Szebb(stoplist));
    }
}