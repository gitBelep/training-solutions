package controllselection.consonant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToConsonant {
    public static void main(String[] args) {
        System.out.println("Kilépés \"é\"-vel");
        Scanner sc = new Scanner(System.in);
        ToConsonant toCo = new ToConsonant();
        char c;
        do {
            System.out.println("Hangzó:");
            c = sc.nextLine().charAt(0);
            System.out.println(toCo.toCons(c));
        } while (c != 'é');
    }

    public char toCons(char c){
        List<Character> abc = new ArrayList<>();
        abc = List.of('a', 'b', 'c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        List<Character> vowel = List.of('a','e','i','o','u');
        if (vowel.contains(c)){
            c = abc.get(abc.indexOf(c)+1);
        }
        return c;
    }
}
