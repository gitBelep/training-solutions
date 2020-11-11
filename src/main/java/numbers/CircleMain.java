package numbers;
import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Kör átmérője?");
        Circle c1 = new Circle(Integer.parseInt(sc.nextLine()));
        System.out.println("2. Kör átmérője?");
        Circle c2 = new Circle(Integer.parseInt(sc.nextLine()));
        System.out.println("1. Kör Kerülete: "+ c1.perimeter() +", Területe: "+ c1.area());
        System.out.println("2. Kör Kerülete: "+ c2.perimeter() +", Területe: "+ c2.area());
    }
}
