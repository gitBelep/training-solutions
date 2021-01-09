//Lehet Scannerből rögtön Tömbbe pakolni?
//List -> Array a feladat előírása szerint -> List
//ez kivételesen a napi feladat Senior változata
package week10d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public int[] findMinMaxSum(int[] arr) {
        List<Integer> numbers = setupList(arr);
        if (numbers.size() <= 4) {
            int result = calcValue(numbers);
            return new int[] {result, result};
        }
//itt az ötlet! A max és min kikeresését és kitörlését kb. 40 sor volt leprogramozni!
        numbers.sort(null);
        int resultMin = calcValue(numbers.subList(0,4));
        int s = numbers.size();
        int resultMax = calcValue(numbers.subList( s-4, s));
        return new int[] {resultMin, resultMax};
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
            int num = Integer.parseInt(scc.next());
            numbers.add(num);
        }

        int[] incomingArray = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            incomingArray[i] = numbers.get(i);
        }

        Calculator c = new Calculator();
        System.out.println(Arrays.toString(c.findMinMaxSum(incomingArray)));
    }
}

