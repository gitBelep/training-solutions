package classstructureio;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        System.out.println("Adj meg 2 egész számot, köztük üss Entert!");
        Scanner sc1 = new Scanner(System.in);
        int number1 = sc1.nextInt();

      //  sc1.nextLine(); //ott maradt sorvég - nem szükséges

        Scanner sc2 = new Scanner(System.in);
        int number2 = sc2.nextInt();

        System.out.println(number1 + "+" + number2 + "=");
        System.out.println(number1 + number2);
    }
}
