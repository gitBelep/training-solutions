package week02d04;

import java.util.Scanner;

public class InputNames {
    public static void main(String[] args) {
        System.out.println("add");
        Scanner sc = new Scanner(System.in);
        String[] n = new String[5];
        for (int i=0; i<5; i++) {
            n[i] = sc.nextLine();
        }
        for (int i=0; i<5; i++) {
            System.out.println((i+1) +"-ik elem: "+ n[i]);
        }
    }
}
