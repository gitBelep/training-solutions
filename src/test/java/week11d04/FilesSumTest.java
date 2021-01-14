package week11d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilesSumTest {

    @Test
    void sumNumbers() {
        FilesSum fs = new FilesSum();

        //240 + 317 = 557
        assertEquals(557, fs.sumNumbers());
    }
}