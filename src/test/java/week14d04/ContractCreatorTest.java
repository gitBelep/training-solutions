package week14d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContractCreatorTest {

    @Test
    void testCreate() {
        ContractCreator co = new ContractCreator("Minta", Arrays.asList(10,10,10));

        Contract contractA = co.create("Aba");
        assertEquals("Aba [10, 10, 10]", contractA.toString());

        Contract contractB = co.create("Béb");
        assertEquals("Béb [10, 10, 10]", contractB.toString());

        contractA.setMonthlyPrices(List.of(20,20,20,20));
        assertEquals("Aba [20, 20, 20, 20]", contractA.toString());
        assertEquals("Béb [10, 10, 10]", contractB.toString());

        contractB.setMonthlyPrices(List.of(30,33));
        assertEquals("Aba [20, 20, 20, 20]", contractA.toString());
        assertEquals("Béb [30, 33]", contractB.toString());

        Contract contractC = co.create("Cec");
        assertEquals("Cec [10, 10, 10]", contractC.toString());
    }


    @Test
    void testCreate2AndCopyConstructor() {
        ContractCreator co = new ContractCreator("Minta", List.of(10,10,10));

        Contract contractA = co.create2("Aba");
        assertEquals("Aba [10, 10, 10]", contractA.toString());

        Contract contractB = co.create2("Béb");
        assertEquals("Béb [10, 10, 10]", contractB.toString());

        contractA.setMonthlyPrices(List.of(20,20,20,20));
        assertEquals("Aba [20, 20, 20, 20]", contractA.toString());
        assertEquals("Béb [10, 10, 10]", contractB.toString());

        contractB.setMonthlyPrices(List.of(30,33));
        assertEquals("Aba [20, 20, 20, 20]", contractA.toString());
        assertEquals("Béb [30, 33]", contractB.toString());

        Contract contractC = co.create2("Cec");
        //System.out.println("később létrehozott "+ contractC.toString());
        assertEquals("Cec [10, 10, 10]", contractC.toString());
    }
}