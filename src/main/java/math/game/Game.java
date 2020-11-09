package math.game;
import java.util.Random;

public class Game {

    public static void main(String[] args) {

        Warriors warriorA = new Warriors("Anton", new Points(2, 4));
        Warriors warriorB = new Warriors("Bertalan", new Points(7,2));

        for (int i=0; i<2; i++) {
            warriorA.move(warriorB.getPosition());
            warriorB.move(warriorA.getPosition());
            if (warriorA.distance(warriorB) ==0){
                warriorA.attack(warriorB);
                warriorB.attack(warriorA);
            }
            System.out.println(warriorA.toString());
            System.out.println(warriorB.toString());
            i = (warriorA.isAlive() && warriorB.isAlive()) ? 0 : 4;


        }
        if (warriorA.isAlive() == true){
            System.out.println("Győztes: "+ warriorA.getName());
        }else{
            System.out.println("Győztes: "+ warriorB.getName());
        }
    }
}
