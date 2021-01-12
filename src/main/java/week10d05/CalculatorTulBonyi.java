package week10d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorTulBonyi {

        public int[] findMinMaxSum2(int[] arr) {
            List<Integer> numbers = setupList(arr);
            if (numbers.size() <= 4) {
                int result = calcValue(numbers);
                int[] resultArray = {result, result};
                return resultArray;
            }
            int result0 = findMin(numbers);
            int result1 = findMax(numbers);
            int[] resultArray = {result0, result1};
            return resultArray;
        }

        private int findMin(List<Integer> numbers) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            List<Integer> mins = new ArrayList<>();
            List<Integer> temp = new ArrayList<>(numbers);
            for (int j = 0; j < 4; j++) {

                for (int i = 0; i < temp.size(); i++) {
                    if (temp.get(i) < min) {
                        min = temp.get(i);
                        minIndex = i;
                    }
                }
                mins.add(min);
                temp.remove(minIndex);
                minIndex = -1;
                min = Integer.MAX_VALUE;
            }
            return calcValue(mins);
        }

        private int findMax(List<Integer> numbers) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            List<Integer> maxes = new ArrayList<>();
            List<Integer> temp = new ArrayList<>(numbers);
            for (int j = 0; j < 4; j++) {

                for (int i = 0; i < temp.size(); i++) {
                    if (temp.get(i) > max) {
                        max = temp.get(i);
                        maxIndex = i;
                    }
                }

                maxes.add(max);
                temp.remove(maxIndex);
                maxIndex = -1;
                max = Integer.MIN_VALUE;
            }
            return calcValue(maxes);
        }

        private int calcValue(List<Integer> values) {
            int result = 0;
            for (int i : values) {
                result += i;
            }
            return result;
        }

        private List<Integer> setupList(int[] arr) {
            List<Integer> numbers = new ArrayList<>();
            for (int i : arr) {
                numbers.add(i);
            }
            return numbers;
        }

        public static void main(String[] args) {
            System.out.println("Adj meg egész számokat vesszővel elválasztva");
            Scanner sc1 = new Scanner(System.in);
            String allTheNumbers = sc1.nextLine();
            Scanner scc = new Scanner(allTheNumbers.replaceAll(" ", "")).useDelimiter(",");
            List<Integer> numbers = new ArrayList<>();
            while (scc.hasNext()) {
                int num = 0;
                try {
                    num = Integer.parseInt(scc.next());
                } catch (NumberFormatException ne) {
                    System.out.println("Ez nem megfelelő szám! Hamis lesz az eredmény");
                }
                numbers.add(num);
            }

            int[] incomingArray = new int[numbers.size()];
            for (int i = 0; i < numbers.size(); i++) {
                incomingArray[i] = numbers.get(i);
            }
            CalculatorTulBonyi c = new CalculatorTulBonyi();
            System.out.println(Arrays.toString(c.findMinMaxSum2(incomingArray)));
        }

}
