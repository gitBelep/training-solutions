package week09d02;
import java.util.ArrayList;
import java.util.List;

public class FibCalculator {

    public long sumEvens1(int bound) {
        if (bound < 2) {
            return check(bound);
        }
        long fib = 0L;
        long sumEvens = 0L;
        List<Long> fibRhye = new ArrayList<>();
        fibRhye.add(1L);
        fibRhye.add(1L);

        for (int i = 1; fib <= bound; i++) {
            if (fib % 2 == 0) {
                sumEvens += fib;
            }
            fib += fibRhye.get(i - 1);
            fibRhye.add(fib);
        }
        return sumEvens;
    }


    public long sumEvens2(int bound) {
        if (bound < 2) {
            return check(bound);
        }
        long result = 0L;
        long fib = 0L;
        long x = 1L;
        long y = 1L;
        long sum;

        while (fib < bound) {
            fib = y;
            sum = y + x;
            y = x;
            x = sum;
            if (fib % 2 == 0) {
                result += fib;
            }
        }
        return result;
    }

    private int check(int bound) {
        if (bound < 0) {
            throw new IllegalArgumentException("Number is too small");
        }
        return 0;
    }

}
