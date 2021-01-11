package week11d01;

public class DivisorFinder {

    public int findDivisors(int n){
        int number = n;
        String strNr =""+n;
        int szamJegy = 0;
        int counter =0;

        for (int i = strNr.length(); i > 0; i--){
            szamJegy = number - (number / 10) * 10;
            if (szamJegy == 0){
                number = number / 10;
                continue;
            }
            if (n % szamJegy == 0){
                counter++;
            }
            number = number / 10;
        }
        return counter;
    }
}
