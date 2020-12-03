package week06d04;

public class Item {
    private int price;
    private int month;
    private String name;

    public Item(int price, int month, String name) {
        if (price < 0){
            throw new IllegalArgumentException("Price must be greater than 0!");
        }
        this.price = price;
        if (month < 1 || month > 12){
            throw new IllegalArgumentException("It is not a valid month!");
        }
        this.month = month;
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("It is not a valid name!");
        }
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public int getMonth() {
        return month;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return price +" "+ name;
    }
}
