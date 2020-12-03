package week06d04;

import introexception.Patient;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BudgetTest {

    @Test
    public void testBudgetWithMonths() {
        Item i1 = new Item(400, 1, "a");
        Item i2 = new Item(400, 12, "b");
        Item i3 = new Item(400, 11, "c");
        Item i4 = new Item(400, 1, "e");

        Budget b = new Budget(List.of(i1, i2, i3, i4));

        assertEquals(2, b.getItemsByMonth(1).size());
        assertEquals("[400 a, 400 e]", b.getItemsByMonth(1).toString());
    }

    @Test
    public void testBudgetWithMonthZero() {
        assertThrows(IllegalArgumentException.class, () -> new Budget(List.of(new Item(400, 1, "A"))).getItemsByMonth(0));
    }

    @Test
    public void testItemWithMonthZero() {
        assertThrows(IllegalArgumentException.class, () -> new Item(400, 0, "A"));
    }

}
