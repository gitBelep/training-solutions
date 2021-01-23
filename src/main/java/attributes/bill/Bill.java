package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double calculateTotalPrise() {
        double total = 0;
        for (Item i: items) {
            total = total + i.getQuantity() * i.getPrice();
        }
        return total;
    }
}
