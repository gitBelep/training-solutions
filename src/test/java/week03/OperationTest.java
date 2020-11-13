package week03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {
    @Test
    void operationTest(){
        Operation opp = new Operation(" 40 + 50 ");
        assertEquals(90, opp.getResult());
    }
}
