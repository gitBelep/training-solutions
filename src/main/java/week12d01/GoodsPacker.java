package week12d01;

import java.util.Arrays;
import java.util.Comparator;

public class GoodsPacker {

    public static void main(String[] args) {
        GoodsPacker g = new GoodsPacker();
        int[][] typesA = {{7, 160}, {3, 90}, {2, 15}};
        System.out.println( g.packGoods(typesA, 20));
    }

//Miből éri meg jobban sokat beletenni, sorba rendezem:
    public int packGoods(int[][] types, int capacity){
        Arrays.sort(types, (i1, i2) -> (int) (i2[1] / ((double) i2[0]) - i1[1] / ((double) i1[0])));
//        Arrays.sort(types, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] i1, int[] i2) {
//                double d1 = i1[1] / ((double) i1[0]);
//                double d2 = i2[1] / ((double) i2[0]);
//                int r = (int) (d2 - d1);
    //            System.out.println("d1: "+ d1 +" d2: "+ d2 +" r: "+ r);
//                return r;
//            }
//        });
        System.out.println(Arrays.deepToString(types));
        int sum = 0;
        for (int i = 0; i < types.length; i++) {
            int pieces = capacity / types[i][0];
            capacity -= pieces * types[i][0];
            sum += pieces * types[i][1];
            System.out.println(pieces +"x"+types[i][0] +". Marad: "+ capacity +", sum: "+sum +" "+ (i+1));
        }
        return sum;
    }

}
