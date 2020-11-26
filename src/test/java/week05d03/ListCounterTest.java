package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {

    @Test
    public void counterTest(){
        List<String> list1 = List.of("alma", "ba", "Ad", "ssa", "Aa", "25", "a", "A", "8a");
        ListCounter ll = new ListCounter();
        assertEquals(5,ll.counter(list1));
    }

    @Test
    public void counterTest2(){
        List<String> list2 = new ArrayList<>();
        ListCounter ll = new ListCounter();
        assertEquals(0,ll.counter(list2));
    }

    @Test
    public void counterTest3(){
        List<String> list3 = List.of("ba", "ssa", "25", "8A");
        ListCounter ll = new ListCounter();
        assertEquals(0,ll.counter(list3));
    }
}
