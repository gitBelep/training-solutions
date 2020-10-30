package classstructureattributes;

import java.util.Scanner;

public class ClientMain{
    public static void mAdain(String[] args) {
        System.out.println("Hello! What's your name?");
        Scanner scName = new Scanner(System.in);
        String name = scName.nextLine();

        System.out.println("Where do you live?");
        Scanner scAddress = new Scanner(System.in);
        String address = scAddress.nextLine();

        System.out.println("How old are you?");
        Scanner scAge = new Scanner(System.in);
        int age = scAge.nextInt();

        System.out.println("Personal Data: " + name+", (" + age + "), "+ address);
    }
}
