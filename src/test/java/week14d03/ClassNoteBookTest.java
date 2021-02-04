package week14d03;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    @Test
    public void sortNotebook() {
        Student st0 = new Student("Tibi");
        Student st1 = new Student("Éva");
        Student st2 = new Student("Álmos");

        ClassNoteBook cnt = new ClassNoteBook(new ArrayList<>(Arrays.asList(st0, st1, st2)));

        st0.giveMark("angol", 1);
        assertEquals(1, st0.getNotes().size());
        st0.giveMark("matek", 5);
        assertEquals(2, st0.getNotes().size());
        assertEquals(1, st0.getNotes().get("angol").size());

        st0.giveMark("angol", 2);
        assertEquals(2, st0.getNotes().get("angol").size());

        st1.giveMark("angol", 5);
        st1.giveMark("matek", 2);
        st1.giveMark("angol", 4);
        assertEquals(2, st1.getNotes().get("angol").size());

        assertEquals("{matek=[5], angol=[1, 2]}", cnt.sortNotebook().get(2).getNotes().toString());

        System.out.println(cnt.sortNotebook().toString());
    }
}