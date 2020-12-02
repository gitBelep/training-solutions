package week06d03;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordEraserTest {

@Test
    public void eraseWordTester(){
    WordEraser w = new WordEraser();

    String words = " A alma sas alma nem eszik alma almát ";
    String word = "alma";

    assertEquals("A sas nem eszik almát", w.eraseWord(words, word));
    }

    @Test
    public void eraseWordSbTester(){
        WordEraser w = new WordEraser();

        String words = " A alma sas alma nem eszik alma almát ";
        String word = "alma";

        assertEquals("A sas nem eszik almát", w.eraseWordWithStringBuilder(words, word));
    }

    @Test
    public void eraseWordScannerTester(){
        WordEraser w = new WordEraser();

        String words = " A alma sas alma nem eszik alma almát ";
        String word = "alma";

        assertEquals("A sas nem eszik almát", w.eraseWithScanner(words, word));
    }
}
