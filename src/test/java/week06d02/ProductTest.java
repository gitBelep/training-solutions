package week06d02;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void createProduct(){
        Product p = new Product("borsó", Category.FROZEN, 780);

        assertEquals(Category.FROZEN, p.getCategory());
        assertEquals(780, p.getPrice());
    }

    @Test
    public void howMuchProductsAreInGivenCategory(){
        Product p = new Product("borsó", Category.FROZEN, 780);
        Product q = new Product("kukorica", Category.OTHER, 480);
        Product r = new Product("rizses", Category.FROZEN, 380);
        Product s = new Product("s", Category.FROZEN, 1780);
        Product t = new Product("tej", Category.DAIRY, 280);
        List<Product> list = List.of(p,q,r,s,t);

        Store store = new Store(list);

        assertEquals(3, store.getProductByCategoryName(Category.FROZEN));
    }
}
