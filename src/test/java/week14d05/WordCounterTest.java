package week14d05;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void testCountWords() throws IOException{
        WordCounter wc = new WordCounter();
        try (BufferedReader br = Files.newBufferedReader(Path.of("c:/training/introide/src/main/resources/Hachiko.srt.txt"), Charset.forName("windows-1250"))) {
            String[] words = new String[]{"Hachiko", "Hachi", "haza", "pályaudvar", "lyaudvar", "jó"};

            Map<String, Integer> result = wc.countWords(br, words);

            //haza 17x, de kettő egy sorban; Hachiko 4x
            System.out.println(result);
            assertEquals(16, result.get("haza"));
            assertEquals(4, result.get("Hachiko"));
        }
    }

}