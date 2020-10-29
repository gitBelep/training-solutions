package classstructureio;

import java.util.Scanner;

public class Registration{
    public static void main(String[] args) {
        System.out.println("Add meg a neved:");
        Scanner scName = new Scanner(System.in);
        String name = scName.nextLine();

        System.out.println("Add meg az e-mail címedet:");
        Scanner scEmail = new Scanner(System.in);
        String email = scEmail.nextLine();

        System.out.println("Regisztrációs adatok - név: " + name + ", e-mail: "+ email);
    }
}

