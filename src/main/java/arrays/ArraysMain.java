package arrays;
import java.util.Arrays;
import static java.util.Arrays.sort;

public class ArraysMain {

    public String sameTempValues(double[] day, double[] anotherDay){
        int i = 0;
        for (i = 0; i< day.length; i++){
            if (day[i] != anotherDay[i]) {
                break;
            }
        }
        String retur = (i == day.length)? "Egyfornák" : "Különböznek";
        return retur;
    }

    public boolean wonLotteryA(int[] a, int[] b){
        int talalat =0;
        for (int j=0; j<b.length; j++){
            for (int i=0; i<a.length; i++) {
                if (a[j] == b[i]) {
                    talalat++;
                    break;
                }
            }
        }
        return talalat == 5;
    }
    public boolean wonLotteryB(int[] a, int[] b){
        sort(a);
        sort(b);
        int j=0;
        for (j=0; j<b.length; j++){
                if (a[j] != b[j]) {
                    break;
                }

        }
        return j == 5;
    }
    public static void main(String[] args) {
        ArraysMain am = new ArraysMain();

        double day1[] = {1.0, 0.1, 0.3, 0.9, 1.0, 1.8, 2.0, 2.5, 2.3, 1.9, 1.5, 1.23};
        double day2[] = {1.0, 0.1, 0.3, 0.9, 1.0, 1.8, 2.0, 2.5, 2.3, 1.9, 1.5, 1.2};
        System.out.println(am.sameTempValues(day1, day2));

        int tipp[] = {41, 21, 3, 2, 88};
        int huzas[] = {3, 88, 21, 41, 2};
        int tipp2[] = Arrays.copyOf(tipp,5);
        int huzas2[] = Arrays.copyOf(huzas,5);

        System.out.println( Arrays.toString(tipp) );
        System.out.println( Arrays.toString(huzas) );
        System.out.println("LottoA:"+ am.wonLotteryA(tipp2, huzas2));
        System.out.println("LottoB:"+ am.wonLotteryB(tipp2, huzas2));
        System.out.println( Arrays.toString(tipp) +"eredeti sorrend megmaradt");
        System.out.println( Arrays.toString(huzas)  +"eredeti sorrend megmaradt");
        System.out.println( Arrays.toString(tipp2) );
        System.out.println( Arrays.toString(huzas2) );

    }
}
