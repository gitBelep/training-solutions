package week06d04;
import java.util.ArrayList;
import java.util.List;

public class Budget {
    private List<Item> items = new ArrayList<>();

    public Budget(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    public List<Item> getItemsByMonth(int month){
        if (month < 1 || month > 12){
            throw new IllegalArgumentException("Month must be between 1 & 12!");
        }
        List<Item> result = new ArrayList<>();
        for (Item i : items){
            if (i.getMonth() == month){
                result.add(i);
            }
        }
        return result;
    }
}
