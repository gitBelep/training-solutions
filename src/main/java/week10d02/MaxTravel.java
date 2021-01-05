package week10d02;
import java.util.List;

public class MaxTravel {

//kiszervezve funkciók szerint, ill for-each-csel
    public int getMaxIndex_Szebb(List<Integer> stops) {
        return choseMostUsedStop( makeStopList(stops) );
    }

     private int[] makeStopList(List<Integer> stops) {
         int[] sums = new int[29];
         for (int i : stops) {
             sums[i]++;
         }
         return sums;
     }

     private int choseMostUsedStop(int[] sums){
        int busStop = 0;
        for (int j = 1; j < sums.length; j++){
            if (sums[j] > sums[busStop]){
                busStop = j;
            }
        }
        return  busStop;
    }


//Saját eredeti megoldás
    public int getMaxIndex(List<Integer> stops){
        int[] sums = new int[29];
        for (int i = 0; i < stops.size(); i++){
            sums[stops.get(i)]++;
        }

        int max =0;
        int busStop = -1;
        for (int j=0; j < sums.length; j++){
            if (sums[j] > max) {
                max = sums[j];
                busStop = j;
            }
        }
        return busStop;
    }

}
