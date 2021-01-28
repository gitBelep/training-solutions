package week13d04;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    @Test
    void merge() {
        TemplateMerger t = new TemplateMerger();
        Path file = Path.of("src/main/resources/week13d04-template.txt");
        List<Employee> eList = new ArrayList<>();
        eList.add( new Employee("Andi", 1991));
        eList.add( new Employee("Bandi", 1992));
        eList.add( new Employee("Cindi", 1993));

        assertTrue(t.merge(file, eList).contains("Andi"));
        assertTrue(t.merge(file, eList).contains("1993"));
        assertTrue(t.merge(file, eList).contains("Bandi"));
        assertTrue(t.merge(file, eList).contains("1992"));
        assertFalse(t.merge(file, eList).contains("{"));
    }

}