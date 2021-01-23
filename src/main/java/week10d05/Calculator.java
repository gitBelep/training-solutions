//ez kivételesen a napi feladat Senior változata
package week10d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public int[] findMinMaxSum(int[] arr) {
//itt az ötlet! A max és min kikeresését és kitörlését kb. 40 sor volt leprogramozni!
        Arrays.sort(arr);
        int resultMin = 0;
        int resultMax = 0;
        int s = arr.length;
        for (int i = 0; i < s && i < 4; i++) {
            resultMax += arr[s - 1 - i];
            resultMin += arr[i];
        }
        return new int[]{resultMin, resultMax};
    }

    public static void main(String[] args) {
        System.out.println("Adj meg egész számokat vesszővel elválasztva");
        Scanner sc1 = new Scanner(System.in);
        String allTheNumbers = sc1.nextLine();
        Scanner scc = new Scanner(allTheNumbers.replaceAll(" ", "")).useDelimiter(",");
        List<Integer> numbers = new ArrayList<>();

// by Arnold Ádám
//        String s = scanner.nextLine();
//        while (!s.isBlank()) {
//            try {
//                numbers.add(Integer.parseInt(s));
//            } catch (NumberFormatException e) {
//                System.out.println("Számot írj!");
//            }
//            s = scanner.nextLine();
//        }

        while (scc.hasNext()) {
            int num = Integer.parseInt(scc.next());
            numbers.add(num);
        }
        int[] incomingArray = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            incomingArray[i] = numbers.get(i);
        }

        Calculator c = new Calculator();
        System.out.print("A négy legkisebb, és a négy legnagyobb összege: ");
        System.out.println(Arrays.toString(c.findMinMaxSum(incomingArray)));
    }
}
