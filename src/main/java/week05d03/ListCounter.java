package week05d03;
import java.util.ArrayList;
import java.util.List;

public class ListCounter {

    public int counter(List<String> list) {
        int pieces = 0;
        if (list.size() == 0) {
            return 0;
        }

        for (String s : list) {
            if (s.charAt(0) == 'A' || s.charAt(0) == 'a') {
                pieces++;
            }
        }
        return pieces;
    }
}
