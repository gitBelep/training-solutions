package catalog;
import java.util.List;

public class Validators {

    static boolean isBlank(String str){
        return (str == null || "".equals(str.trim()) );
    }

    static boolean isEmpty(List list){
        return (list == null || list.size() == 0);
    }
}
