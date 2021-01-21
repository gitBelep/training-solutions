package week03;

import org.junit.jupiter.api.Test;
import week03d04.Phone;
import week03d04.PhoneParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParsePhoneTest {
    @Test
    void testParsePhone1() {
        PhoneParser par = new PhoneParser();
        Phone ph = par.parsePhone("123-123456");
        assertEquals("123", ph.getPrefix());
    }
    @Test
    void testParsePhone2() {
        PhoneParser par = new PhoneParser();
        Phone ph = par.parsePhone("123-123456");
        assertEquals("123456", ph.getNumber());
    }
    @Test
    void testParsePhone3() {
        PhoneParser par = new PhoneParser();
        Phone ph = par.parsePhone("20-1234567");
        assertEquals("06 \\ 20 - 123 - 4567", ph.toString());

    }
}
