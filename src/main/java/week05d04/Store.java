package week05d04;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product pr){
        productList.add(pr);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getNumberOfExpired(){
        LocalDate today = LocalDate.now();
        System.out.println(today);
        int expired =0;
        for ( Product p : productList){
            if (p.getExp().isBefore(today)) {
                expired++;
                System.out.println(expired);
            }
        }
        return expired + " db. termék lejárt!";
    }


}
