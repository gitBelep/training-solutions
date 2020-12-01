package week06d02;
import java.util.List;

public class Store {
    private List<Product> productList;

    public Store(List<Product> productList) {
        this.productList = productList;
    }

    public int getProductByCategoryName(Category cat){
        int amount = 0;
        for (Product p : productList){
 //         if (p.getCategory().name().equals(cat.name())) {    //bonyolult
            if (p.getCategory() == cat){
                amount++;
            }
        }
        return amount;
    }
}
