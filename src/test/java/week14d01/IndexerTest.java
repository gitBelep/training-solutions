package week14d01;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class IndexerTest {

    @Test
    void index() {
        Indexer indexer = new Indexer();

        List<String> names = new ArrayList<>(Arrays.asList(
            "Zénó", "Éva", "Zoárd", "Álmos", "8", "-", "-8", "Gennagyíj", "Ada", "Ábrahám", "Gazsi"));

        Map<Character, List<String>> result = indexer.index(names);
        System.out.println(result);

        assertEquals(7, result.size());
        assertEquals("[Gennagyíj, Gazsi]", result.get('G').toString());
    }

    @Test
    void indexNincsTulaggodva() {
        Indexer indexer = new Indexer();

        List<String> names = new ArrayList<>(Arrays.asList(
                "Zénó", "Zoárd", "Álmos", "8", "-", "-8", "Gennagyíj", "Ada", "Ábrahám", "Gazsi"));

        Map<Character, List<String>> result = indexer.index(names);
        System.out.println(result);

        assertEquals(6, result.size());
        assertEquals("[Gennagyíj, Gazsi]", result.get('G').toString());
    }

}