package week03;
import java.util.Scanner;

public class Employeee {
    private String name;

    public Employeee (String name){
        if (name == null || name.trim().equals("")){
            throw new IllegalArgumentException("Üres mező! ");
        }
        this.name = name;
    }
    public  String getName(){
        return name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employeee e = null;
        while (e == null){
            System.out.println("Név?");
            String nameIn = sc.nextLine();
            try{
                e = new Employeee(nameIn);
            }catch (IllegalArgumentException i){
                System.out.println(i + " Adj meg újat:");
            }
        }
        System.out.println("A név: "+ e.getName());
    }
}
