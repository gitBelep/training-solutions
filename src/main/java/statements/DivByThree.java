package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        System.out.println("Adj meg egy számot");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(number % 3 ==0? "osztható 3-mal":"nem osztható 3-mal");
    }
}
