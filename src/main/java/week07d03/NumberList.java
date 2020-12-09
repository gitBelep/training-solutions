package week07d03;
import java.util.List;

public class NumberList{

        public boolean isIncreasing(List<Integer> list) {
            if (list.size() < 2) {
                return true;
            }
//Vagy kiemelni az 1. elemet..
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i+1) < list.get(i)) {
                    return false;
                }
            }
            return true;
        }
}
