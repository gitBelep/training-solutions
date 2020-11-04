package introcontrol;

import java.util.Scanner;

public class IntroControlMain {
    public static void main(String[] args) {
        System.out.println("Számod?");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println("2. számod?");
        int num2 = sc.nextInt();
        sc.nextLine();

        IntroControl ic = new IntroControl(num);
        System.out.println(ic.substractTenIfGreaterThanTen(num));
        System.out.println(ic.describeNumber(num));
        ic.printNumbersBetweenAnyDirection(num,num2);
    }
}
