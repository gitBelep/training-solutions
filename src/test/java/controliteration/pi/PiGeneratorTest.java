
package controliteration.pi;
import controliteration.pi.PiGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PiGeneratorTest {

    @Test
    public void testGetPi() {
        //G
        String versPirol = "Nem a, régi s durva közelítés, mi szótól szóig így kijön betűiket számlálva. Ludolph eredménye már, ha itt végezzük húsz jegyen. \n" +
                "De rendre kijő még tíz pontosan. Azt is bízvást ígérhetem.";
        //W
        PiGenerator pi = new PiGenerator(versPirol);
        //T
        assertEquals("3.141592653589793238462643383279", pi.getPi());
    }
}
