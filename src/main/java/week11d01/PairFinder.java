package week11d01;

import java.util.*;

public class PairFinder {

    public int findPairs(int[] arr){
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i : arr){
            if(pairs.containsKey(i)){
                pairs.put(i, pairs.get(i)+1);
            } else {
                pairs.put(i,1);
            }
        }

        int pairAmount = 0;
        int actual = 0;
        for (Map.Entry<Integer, Integer> e : pairs.entrySet()){
            if ( (actual = e.getValue()/2) > 0){  //egész osztás
                pairAmount += actual;
            }
        }
        return pairAmount;
    }


    public static void main(String[] args) {
        PairFinder lets = new PairFinder();
                                    //      1     1  1      1     !           1
        int[] amongThese = new int[]{0,2,-4,0,151,2,-4,152,151,2,-0,-7,7,-152,0};
        int result = lets.findPairs(amongThese);
        System.out.println(Arrays.toString(amongThese));
        System.out.println(result +" db pár lett.");
    }

}
