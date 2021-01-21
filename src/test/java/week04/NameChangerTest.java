package week04;

import org.junit.jupiter.api.Test;
import week04d01.NameChanger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameChangerTest {

    @Test
    public void makeNcTest() {
        NameChanger nc = new NameChanger("");
        assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
  }

    @Test
    public  void changeFirstNameTest(){
        NameChanger nc = new NameChanger("Ede Kovi");
        nc.changeFirstName("Anna");
        assertEquals("Anna Kovi", nc.getFullName());
    }
}
