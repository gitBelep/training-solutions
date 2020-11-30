package week06d01;
import java.util.ArrayList;
import java.util.List;

public class ListSelector {

    public  String getEverySecond(List<String> list){
        if (list == null){
            throw new IllegalArgumentException("Null Lista");
        }
        if (list.size()==0){
            return "[]";
        }

        List<String> newList = new ArrayList<>();
        for (int i=0; i<list.size(); i=i+2){
            newList.add(list.get(i));
        }
        return newList.toString();
    }
}
