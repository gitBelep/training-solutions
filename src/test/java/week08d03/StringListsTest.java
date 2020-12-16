package week08d03;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListsTest {

    @Test
    public void testListsUnion(){
        StringLists sl = new StringLists();
        List<String> list1 = Arrays.asList("a", "baba", "c");
        List<String> list2 = Arrays.asList("A", "baba", "cx", "c", "6");

        assertEquals("[a, baba, c, A, cx, 6]",sl.stringListsUnion(list1, list2).toString());
    }

    @Test
    public void testListsUnionIgnoreCase(){
        StringLists sl = new StringLists();
        List<String> list1 = Arrays.asList("a", "baBa", "cC");
        List<String> list2 = Arrays.asList("A", "baba", "Cc", "6");

        assertEquals("[a, baBa, cC, 6]",sl.stringListsUnionIgnoreCase(list1, list2).toString());
    }
}
