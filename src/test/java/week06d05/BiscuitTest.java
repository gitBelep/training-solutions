package week06d05;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BiscuitTest {

    @Test
    public void checkCreate(){
        Exception ex = assertThrows( IllegalArgumentException.class, () -> new Biscuit(BiscuitType.PILÓTA,200_000) );
        assertEquals("It is not a retail pack.", ex.getMessage());
    }

    @Test
    public void checkBiscuitOf(){
        assertEquals("Biscuit{type=HÁZTARTÁSI, gramAmount=1000}",Biscuit.of(BiscuitType.HÁZTARTÁSI, 1_000).toString());
    }
}
