package statements;
import java.util.Scanner;
public class TimeMain {
    public static void main(String[] args) {
        Time z = new Time(1,1,1);
        System.out.println("Adj meg egy időpontot! óra?");
        Scanner sc1 = new Scanner(System.in);
        int h1 = sc1.nextInt();
        System.out.println("perc?");
        int m1 = sc1.nextInt();
        System.out.println("másodperc?");
        int s1 = sc1.nextInt();
        Time firstTime = new Time(h1,m1,s1);
        System.out.println("Adj meg egy második időpontot! óra?");
        h1 = sc1.nextInt();
        System.out.println("perc?");
        m1 = sc1.nextInt();
        System.out.println("másodperc?");
        s1 = sc1.nextInt();
        Time secondTime = new Time(h1,m1,s1);
        System.out.println("Az első időpont "+ z.toString(firstTime) +" = "+ z.getInMinutes(firstTime) +" perc");
        System.out.println("A második  "+ z.toString(secondTime) +" = "+ z.getInSeconds(secondTime) +" másodperc");
        System.out.println("Az első korábbi, mint a második: "+ z.earlierThan(firstTime,secondTime));
    }
}
