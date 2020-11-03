package statements;
import java.util.Scanner;
public class InvestmentMain {
    public static void main(String[] args) {
        System.out.println("Betét összege?");
        Scanner sc = new Scanner(System.in);
        int fu = sc.nextInt();
        System.out.println("Kamatláb (%)");
        int intR = sc.nextInt();
        Investment investment = new Investment(intR, fu);
        System.out.println("Hány nap után érdekelnek a kamatok?");
        int da = sc.nextInt();
        System.out.println(da);
        System.out.println(investment.getYield(da));
        System.out.println("Hány nap után veszed ki a betétet?");
        int end = sc.nextInt();
        System.out.println(investment.close(end));
        System.out.println("További kivehető összeg: "+ investment.close(end));
    }
}
