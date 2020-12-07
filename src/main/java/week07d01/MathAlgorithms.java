package week07d01;

public class MathAlgorithms {

    public static boolean IS_PRIME(int x){
        boolean isPrim = true;
        if (x == 2){
            return true;
        }
        if (x == 1){
            return false;
        }
        for (int i = 2; i <= Math.pow(x,0.5)+1; i++){
            if (x % i ==0){
                isPrim = false;
            }
        }
        return isPrim;
    }

    public static boolean IS_PRIME_B(int x){
        int collect = 0;
        for (int i = 1; i <= x; i++){
            if (x % i == 0){
                collect ++;
            }
        }
        return collect == 2 ? true : false;
    }
}
