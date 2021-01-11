package week11d01;

public class DivisorFinder {

//saját:
    public int findDivisors(int n){  //negatívnál 0 fut rajta végig
        int number = n;
        String strNr =""+n;
        int digit;
        int counter =0;

        for (int i = strNr.length(); i > 0; i--){
            digit = number - (number / 10) * 10;
            if (digit == 0){             //0-val osztásként étrékeli az "int%0"-t.
                number = number / 10;
                continue;
            }
            if (n % digit == 0){
                counter++;
            }
            number = number / 10;
        }
        return counter;
    }

// órai
    public int findDivisors2(int n) {
        int number;
        number = n < 0 ? -1 * n : n;  //negatívot pozitívvá kell tenni, vagy feltétel kell..
        int counter = 0;
        String strNr = Integer.toString(number);
        char[] charNr = strNr.toCharArray(); //vagy Integer.parseInt(substring(i,i+1))

        for (char c : charNr) {
            if (Integer.parseInt((String.valueOf(c))) == 0){
                continue;
            }
            if (number % Integer.parseInt((String.valueOf(c))) == 0) {
                counter++;
            }
        }
        return counter;
    }
//Megnézzük a szám minden egyes számjegyére, hogy osztója-e a számnak, majd
// számoljuk össze őket. Példa: a 425-ben az 5 osztója a számnak, ezért
// a visszatérési érték 0+0+1 = 1.
}
