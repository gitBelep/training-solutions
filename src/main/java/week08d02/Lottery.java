package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    public List<Integer> getNumbers(){
        List<Integer> numbers = new ArrayList<>();
        Random rnd = new Random();
        int n = 100;
        while ( numbers.size() < 5 ) {
            n = rnd.nextInt(90)+1;
            if ( !numbers.contains(n) ) {
                numbers.add(n);
            }
        }
        return numbers;
    }


    public static void main(String[] args) {
        Lottery m = new Lottery();
        System.out.println(m.getNumbers());
        System.out.println(m.getNumbers());
        System.out.println(m.getNumbers());
        System.out.println(m.getNumbers());
        System.out.println(m.getNumbers());
        System.out.println(m.getNumbers());
        System.out.println(m.getNumbers());
        System.out.println(m.getNumbers());
    }
}
