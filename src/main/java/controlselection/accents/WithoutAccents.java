package controlselection.accents;
import java.util.List;
import java.util.Scanner;

public class WithoutAccents {

    public static void main(String[] args) {
        System.out.println("Kilépés \"1\"-essel");
        Scanner sc = new Scanner(System.in);
        WithoutAccents wAcc = new WithoutAccents();
        char c;
        do {
            System.out.println("Ékezetes betűd:");
            c = sc.nextLine().charAt(0);
            System.out.println(wAcc.withoutAccents(c));
        } while (c != '1');
    }

    public char withoutAccents(char c) {
        List<Character> accent = List.of('á', 'é', 'í', 'ó', 'ö', 'ő', 'ú', 'ü', 'ű');
        List<Character> without = List.of('a', 'e', 'i', 'o', 'o', 'o', 'u', 'u', 'u');
        if (without.contains(c)) {
            return c;
        } else {
            for (char ca : accent) {
                if (c == ca) {
                    c = without.get(accent.indexOf(ca));
                }
            }
            return c;
        }
    }
}