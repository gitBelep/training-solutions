package week06d04;
import java.util.ArrayList;
import java.util.List;

public class Budget {
    private List<Item> items = new ArrayList<>();

    public Budget(List<Item> items) {
        if (items == null || items.size() ==0){
            throw new IllegalArgumentException("Feltöltött listát várok!");
        }
        this.items = items;
    }

    public String getItemsByMonth(int month){
        List<Integer> result = new ArrayList<>();
        for (Item i : items){
            if (i.getMonth() == month){
                result.add(i.getPrice());
            }
        }
        return result.toString();
    }
}
