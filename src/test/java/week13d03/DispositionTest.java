package week13d03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DispositionTest {

    @Test
    void classesPerWeek() {
        Disposition d = new Disposition();

        //6 4 1 4 4 4
        assertEquals(23, d.classesPerWeek("Medve Melani"));
        System.out.println();
        //1 1 3 5 3 1 1 3 2 2 2
        assertEquals(24, d.classesPerWeek("Oposszum Opika"));
        System.out.println();
        //4 6 4 3 1 6
        assertEquals(24, d.classesPerWeek("Panda Patrik"));
    }
}