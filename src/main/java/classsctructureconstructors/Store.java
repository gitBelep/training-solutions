package classsctructureconstructors;

public class Store {
    private String product;
    private int stock =0;

    public Store(String prod){
        this.product = prod;
    }

    public void store(int plus){
        this.stock = this.stock + plus;
    }

    public void dispatch(int minus){
        stock = stock - minus;
    }

    public int getStock(){
        return stock;
    }
    public String getProduct(){
        return product;
    }
}
