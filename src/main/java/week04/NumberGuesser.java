package week04;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rnd = (int) (Math.random()*100+1);
        System.out.println("csalás: "+ rnd);
        do{
            System.out.println("Tippelj egy számot 1 és 100 közt");
            int gu = Integer.parseInt(sc.nextLine());

            if (gu == rnd){
                System.out.println("Találat!");
                rnd = (int) (Math.random()*100+1);
            }else{
                if (gu > rnd){
                    System.out.println("Kisebb számra gondoltam");
                }else{
                    System.out.println("Nagyobb számra gondoltam");
                }
            }
        }while (!sc.equals("q"));
    }
}
