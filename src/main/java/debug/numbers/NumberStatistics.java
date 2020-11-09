package debug.numbers;
import java.util.Arrays;
import java.util.List;

public class NumberStatistics {
    private List<Integer> numbers;

    public NumberStatistics(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sumPositives() {
        int sum = 0;
        for(int n: numbers) {
            if(n > 0) {
                sum += n;
            }
        }
        return sum;
    }

    public int minDifferenceBetweenNeighbours() {
        int minDifference = 0;
        if (numbers.size()<2){
            System.out.println("IllegalStateException");
        }else {
            minDifference = numbers.get(0) - numbers.get(1) >= 0 ? numbers.get(0) - numbers.get(1) : numbers.get(1) - numbers.get(0);
            for (int i = 1; i < numbers.size() - 1; i++) {
                int actDifference = Math.abs(numbers.get(i) - numbers.get(i + 1));
                if (actDifference < minDifference) {
                    minDifference = actDifference;
                }
            }
            System.out.println(minDifference);
        }
        return minDifference;
    }

    public static void main(String[] args) {
        NumberStatistics nr = new NumberStatistics(Arrays.asList(4, 8, -1, -2, 4, 5, 3));
        System.out.println(nr.sumPositives());
        NumberStatistics nr2 = new NumberStatistics(Arrays.asList(-3, -4));
        System.out.println(nr2.sumPositives());

        nr.minDifferenceBetweenNeighbours();
        NumberStatistics nr3 = new NumberStatistics(Arrays.asList(1));
        nr3.minDifferenceBetweenNeighbours();
    }
}
