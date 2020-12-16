package week08d03;
import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> stringListsUnion(List<String> first, List<String> second){
        List<String> union = new ArrayList<>(first);
        for (String s : second){
            if (!union.contains(s)){
                union.add(s);
            }
        }
        return union;
    }

//Kiegészítve kis- és nagybetű ignorálásával
    public List<String> stringListsUnionIgnoreCase(List<String> first, List<String> second){
        List<String> union = new ArrayList<>(first);
        for (String s : second){
            if (!containsIgnoreCase(union, s)) {
                union.add(s);
            }
        }
        return union;
    }

    private boolean containsIgnoreCase(List<String> words, String newStr){
        for (String ss: words){
            if ( ss.toUpperCase().equals(newStr.toUpperCase()) ){
                return true;
            }
        }
        return false;
    }
}
