package week06d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetTest {

    @Test
            public void testMonth() {
        Item i1 = new Item(400, 1, "a");
        Item i2 = new Item(400, 12, "a");
        Item i3 = new Item(400, 11, "a");
        Item i4 = new Item(400, 1, "e");

        Budget b = new Budget(List.of(i1, i2, i3, i4));

        assertEquals("[400, 400]", b.getItemsByMonth(1));
    }
}
