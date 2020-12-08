package week07d02;
import static java.lang.Integer.parseInt;

public class DigitSum {
    public int sumOfDigits(int x) {
        String strNumber = Integer.toString(x);
        int sum = 0;
        String ss = "";
        Character c = null;
        for (int i = 0; i < strNumber.length(); i++) {
            c = (Character) strNumber.charAt(i);
            ss = Character.toString(c);
            sum += parseInt(ss);
        }
        return sum;
    }

    public static int sumOfDigitsMuchBetterIdea(int x) {
        int sum = 0;
        while (x != 0) {
            sum = sum + x % 10;
            x = x / 10;
        }
        return sum;
    }
}
