package week04;

import java.util.ArrayList;
import java.util.List;

public class Charfinder {

    public class Main {
        public static void main(String[] args) {
        }

        List<Integer> getIndexesOfChar(String str, char c) {
            List<Integer> result = new ArrayList<>();
            Character cc = c;
            int place  = str.indexOf(c);
            for (int i =0; i < str.length(); i++){
                result.add(str.indexOf(c,place));
                place = result.get(result.size()-1);
            }
            return result;
        }
    }
}
