package introcontrol;
import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {
        System.out.println("Hányan jöttetek?");
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();

        if (group<=2){
            System.out.println("2 személyes csónakot vittek");
        }else{
            if(group ==3){
                System.out.println("3 személyes csónakot vittek");
            }else{
                if (group<=5){
                    System.out.println("5 személyes csónakot vittek");
                }else{
                    if (group<=7){
                        System.out.println("5 és 2 személyes csónakot vittek");
                    }else{
                        if (group==8){
                            System.out.println("5 és 3személyes csónakot vittek");
                        }else{
                            System.out.println("Mind3 csónakot kikölcsönözték");
                            if (group>10){
                                System.out.println(group-10+"-en maradtak a parton");
                            }
                        }
                    }
                }
            }
        }
    }
}
