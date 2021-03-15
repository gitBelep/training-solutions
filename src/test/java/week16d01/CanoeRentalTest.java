package week16d01;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CanoeRentalTest {

    @Test
    public void make() {
        CanoeRental cr1 = new CanoeRental("Dd", CanoeType.GREEN, "2021.01.28 11:05");
        System.out.println(cr1.getStartTime());

        cr1.setEndTime(LocalDateTime.of(2021,1,29,17,12));

        System.out.println(cr1.calculateRentalSum());
        //1807 min ~  30,11h -> 31h *5000 *1,2 = 186_000
        assertEquals(186_000, cr1.calculateRentalSum());

    }

}