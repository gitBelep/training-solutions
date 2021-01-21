package week03d05;
import java.util.Scanner;

public class OperationB {
        private int leftValue;
        private int rightValue;

        public OperationB(String str) {
            this.leftValue = Integer.parseInt(str.substring(0, str.indexOf("+")).trim());
            this.rightValue = Integer.parseInt(str.substring(str.indexOf("+")+1).trim());
        }

        public int getResult(){
            return leftValue+rightValue;
        }

        public static void main(String[] args) {
            OperationB opp = null;
            Scanner sc = new Scanner(System.in);
            while (opp == null) {
                System.out.println("Összeadás ~  int + int formátumban");
                String muvelet = sc.nextLine();
                try {
                    opp = new OperationB(muvelet);
                } catch (IllegalArgumentException | StringIndexOutOfBoundsException ie) {
//  throw new IllegalArgumentException("Helytelen formátum! Újra: ");  -- erre kilépne
                    System.out.println(ie);
                }
            }
            System.out.println("Eredmény: "+ opp.getResult());
        }
}
