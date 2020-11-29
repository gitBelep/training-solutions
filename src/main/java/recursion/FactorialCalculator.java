package recursion;

public class FactorialCalculator {

    public long getFactorial(int n) {
        long factorial = 0L;
        if (n == 1) {
            return (long) n;
        }
        factorial = n * getFactorial(n-1);
        return factorial;
    }

//    public static void main(String[] args) {
//        FactorialCalculator fc = new FactorialCalculator();
//        String s = "";
//        for (int j = 1; j < 22; j++) {
//            s = String.format("%30d", fc.getFactorial(j));
//            System.out.println(s);
//        }
//        System.out.println("És túlcsordult");
//    }
}
