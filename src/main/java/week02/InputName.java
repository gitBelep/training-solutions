package week02;

import java.util.Scanner;

public class InputName {
    public static void main(String[] args) {
        System.out.println("add");
        Scanner sc = new Scanner(System.in);
        String[] n = new String[5];
        for (int i=0; i<5; i++) {
            n[i] = sc.nextLine();
        }
        for (int i=0; i<5; i++) {
            System.out.println(n[i] + 1+i+"-ik elem");
        }

    }

}
