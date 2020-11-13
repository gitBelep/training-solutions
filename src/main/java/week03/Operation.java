package week03;

import java.util.Scanner;

public class Operation {
    private int leftValue;
    private int rightValue;

    public Operation(String str){
        this.leftValue = Integer.parseInt(str.substring(0, str.indexOf("+")).trim());
        this.rightValue = Integer.parseInt(str.substring(str.indexOf("+")+1).trim());
    }

    public int getResult(){
        return leftValue+rightValue;
    }

    public static void main(String[] args) {
        System.out.println("Összeadás ~  int + int formátumban");
        Scanner sc = new Scanner(System.in);
        String muvelet = sc.nextLine();
        Operation opp = null;  //kivül létrehoz, h lehessen vizsgálni
        while (opp == null) {
            try {
                opp = new Operation(muvelet);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
        System.out.println(opp.getResult());
    }
}

