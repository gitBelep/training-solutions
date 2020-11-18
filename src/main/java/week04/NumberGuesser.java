package week04;

import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rnd = (int) (Math.random()*101);
        do{
            System.out.println("Tippelj egy számot 1 és 100 közt");
            int gu = Integer.parseInt(sc.nextLine());

            if (gu == rnd){
                System.out.println("Találat!");
            }

        }while (!sc.equals("q"));
    }

}
