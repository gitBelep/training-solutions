package Statements2;

import java.util.Scanner;

public class TimeMain2 {

        public static void main(String[] args) {
            System.out.println("Adj meg egy időpontot! óra?");
            Scanner sc1 = new Scanner(System.in);
            int h1 = sc1.nextInt();
            System.out.println("perc?");
            int m1 = sc1.nextInt();
            System.out.println("másodperc?");
            int s1 = sc1.nextInt();
            Time2 firstTime = new Time2(h1,m1,s1);
            System.out.println("Adj meg egy második időpontot! óra?");
            h1 = sc1.nextInt();
            System.out.println("perc?");
            m1 = sc1.nextInt();
            System.out.println("másodperc?");
            s1 = sc1.nextInt();
            Time2 secondTime = new Time2(h1,m1,s1);
            System.out.println("Az első időpont "+ firstTime.toString() +" = "+ firstTime.getInMinutes() +" perc");
            System.out.println("A második  "+ secondTime.toString() +" = "+ secondTime.getInSeconds() +" másodperc");
            System.out.println("Az első korábbi, mint a második: "+ firstTime.earlierThan(secondTime));
        }
}
