package methodoverloading.pub;

import methodoverloading.Time;
import java.util.List;

public class ListOfGoodPubs {
    private List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs){
        if (goodPubs == null || goodPubs.size() == 0){
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest(){
        Time bestTime = new Time(23,59,59);
        int best = 0;
        for (int i =0; i < goodPubs.size(); i++) {
            if (goodPubs.get(i).getOpenFrom().isEarlier(bestTime)) {
                bestTime = goodPubs.get(i).getOpenFrom();
                best = i;
            }
        }
        return goodPubs.get(best);
    }
}
