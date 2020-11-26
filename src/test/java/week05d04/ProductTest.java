package week05d04;

import org.junit.jupiter.api.Test;
import week05d04.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testingStroeAdd(){
        Store s = new Store();
        Product a = new Product("vaj", 2020,11,30);

        s.addProduct(a);

        assertEquals(LocalDate.of(2020,11,30),s.getProductList().get(0).getExp());
    }

    @Test
    public void testingStroeExp(){
        Store s = new Store();
        Product a = new Product("vaj", 2020,11,30);
        Product b = new Product("tej", 2020,11,20);
        Product c = new Product("tea", 2021,1,30);

        s.addProduct(a);
        s.addProduct(b);
        s.addProduct(c);

        assertEquals("1 db. termék lejárt!",s.getNumberOfExpired());
    }

}

