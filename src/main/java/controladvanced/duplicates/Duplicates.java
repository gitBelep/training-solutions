package controladvanced.duplicates;
import java.util.ArrayList;
import java.util.List;

public class Duplicates {
    public List<Integer> find(List<Integer> numbers) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i=0; i < numbers.size(); i++){
            for (int j=i+1; j < numbers.size(); j++) {
                 if (numbers.get(i) == numbers.get(j)) {
                    duplicates.add(numbers.get(j));
                    break;
                 }
            }
        }
        return duplicates;
    }
}



