package week05d05;

import org.junit.jupiter.api.Test;
import stringmethods.filename.FileNameManipulator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    public void getUserFullname2() {
        User u = new User("Aba", "Béla", "er@freemail.ru");

        assertEquals("Aba Béla",u.getFullName());
    }
    @Test
    public void emailOk2() {
        User u = new User("Aba", "Béla", "er@freemail.ru");
        assertEquals("er@freemail.ru", u.geteMail());
    }
    @Test
    public void emailDoesntContainsAt() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new User("Aba", "Béla", "er.freemail.ru");
        });
        assertEquals("e-mail should contain \".\" and \"@\" !", ex.getMessage());
    }
    @Test
    public void emailDoesntContainsDot() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new User("Aba", "Béla", "er@freemail@ru");
        });
        assertEquals("e-mail should contain \".\" and \"@\" !", ex.getMessage());
    }
}
