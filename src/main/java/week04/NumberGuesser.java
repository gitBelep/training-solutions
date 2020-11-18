package week04;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rnd = (int) (Math.random()*100+1);
        int kor =2;
        String out = null;
        System.out.println("JÁTÉK    by dd\n   >>Találd ki a számot<<\nkilépés \"q\"-val.");
        System.out.println("\nTippelj egy számot 1 és 100 közt!\n7 lehetőséged van");

        do {
            int gu =-1001;
            while (gu == -1001) {
                try {
                    out = sc.nextLine();              //Beolvasás
                    if ("q".equals(out)){break;}      //belsőből kiugrik
                    gu = Integer.parseInt(out);
                } catch (NumberFormatException nfe) {
                    System.out.println("Számra gondoltam!!  Nos?");
                }
            }
            if ("q".equals(out)){break;}

            if (gu == rnd){                            //Találat?
                System.out.println(" *  G r a t u l á l o k !  K i t a l á l t a d !  *\n");
                System.out.println("Tippelj egy számot 1 és 100 közt!\n7 lehetőséged van");
                rnd = (int) (Math.random()*100+1);
                kor = 2;
                continue;
            }else{
                if (gu > rnd){
                    System.out.println("Kisebb számra gondoltam..");
                }else{
                    System.out.println("Nagyobb számra gondoltam..");
                }
            }

            if (kor == 8){
                System.out.println("Ez most nem sikerült  :-( \n   * * Vége * *");
                break;
            }
            System.out.println(kor +(". kör.  Új tipped?"));
            kor++;
        }while (true);
    }
}
