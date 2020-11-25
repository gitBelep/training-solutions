package week04;
import java.util.ArrayList;
import java.util.List;

public class Charfinder {

    public static void main(String[] args) {
        Charfinder m = new Charfinder();
        System.out.println(m.getIndexesOfChar("Elmesél, szeletel", "e"));
    }

    public List<Integer> getIndexesOfChar(String strBe, String betu) {
        List<Integer> result = new ArrayList<>();
        String str = strBe.toLowerCase();
        for (int i =0; i<str.length(); i++) {
            if ( (str.substring(i,i+1)).equals(betu) ){
                result.add(i);
            }
        }
        return result;
    }

}

