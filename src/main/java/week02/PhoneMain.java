package week02;

import java.util.Scanner;

public class PhoneMain {
    public static void main(String[] args) {
        System.out.println("Típus?");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("mem?");
        int me = sc.nextInt();
        Phone phone1 = new Phone(str,me);
        String str2 = sc.nextLine();

        System.out.println("Típus?");
        str = sc.nextLine();
        System.out.println("mem?");
        me = sc.nextInt();
        Phone phone2 = new Phone(str,me);

        System.out.println(phone1.getMem() + phone1.getType());
        System.out.println(phone2.getMem() + phone2.getType());

    }
}
