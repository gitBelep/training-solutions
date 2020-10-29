package classstructureio;

import java.util.Scanner;

public class Calculatorr {

        public static void main(String[] args) {
            System.out.println("Adj meg egy egész számot:");
            Scanner sc1 = new Scanner(System.in);
            int number1 = sc1.nextInt();

            //  sc1.nextLine(); //ott maradt sorvég - nem szükséges
            System.out.println("Adj meg egy másik egész számot:");

            Scanner sc2 = new Scanner(System.in);
            int number2 = sc2.nextInt();

            System.out.println(number1 + "+" + number2 + "=");
            System.out.println(number1 + number2);
        }
        
}
