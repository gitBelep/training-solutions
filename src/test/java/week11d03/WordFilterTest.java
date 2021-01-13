package week11d03;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WordFilterTest {

    @Test
    public void wordFilterTest() {
        WordFilter w = new WordFilter();

        List<String> wordList = List.of("alma", "ALOM", "álom", "béTA");
        assertEquals(3, w.wordsWithChar(wordList,'a').size());
        assertEquals(3, w.wordsWithChar(wordList,'M').size());
        assertEquals(0, w.wordsWithChar(wordList,']').size());

    }
}