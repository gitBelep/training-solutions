package numbers;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        System.out.println("Oldd meg: \n ((3 - 2) * (500 - 1) - (33 * 3)) : -800 + 0,8 =");
        Scanner sc = new Scanner(System.in);
        double usersTipp = sc.nextDouble();
        double d = ((3 - 2) * (500 - 1) - (33 * 3)) / -800.0 + 0.8;
        //          ( 1     *  499      - 99 )= 400 -> : -800 = -0,5 -> +0,8 = 0,3
        if( Math.abs(usersTipp - d) < 0.0001){
            System.out.println("Helyes!");
        }else{
            System.out.println("Rossz megoldás!");
        }
        System.out.println("Eredmény="+ d + "; Eltérés="+ Math.abs(usersTipp - d));
    }
}