package week07d04;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LabTest {
    @Test
    public void laborareWithoutDate(){
        Lab lab = new Lab("Napi feladat");

        assertEquals("Napi feladat",lab.getTitle());
        assertEquals(null, lab.getCompletedAt());
        assertFalse(lab.isCompleted());
    }

    @Test
    public void laborareWithDate(){
        Lab lab = new Lab("Metódustúlterhelés",LocalDate.of(2020,12,8));

        assertEquals("Metódustúlterhelés", lab.getTitle());
        assertEquals(LocalDate.of(2020,12,8), lab.getCompletedAt());
        assertTrue(lab.isCompleted());
    }

    @Test
    public void completeWithoutDate(){
        Lab lab = new Lab("12.10.");

        lab.complete(LocalDate.of(1848,3,15));

        assertEquals(LocalDate.of(1848,3,15),lab.getCompletedAt());
    }

    @Test
    public void completeWitNowDate(){
        Lab lab = new Lab("complete");

        lab.complete();

        assertEquals(LocalDate.now(),lab.getCompletedAt());
    }
}
