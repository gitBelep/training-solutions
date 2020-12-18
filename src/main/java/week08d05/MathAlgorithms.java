package week08d05;

public class MathAlgorithms {

    public int greatestCommonDivisor(int a, int b) {
        int lnko = 1;
        for (int i = 2; i <= Math.min(a,b); i++) {
            if (a % i == 0 && b % i == 0) {
                lnko = i;
            }
        }
        return lnko;
    }

    public int greatestCommonDivisorEuclidean(int c, int d){
        int temp = 0;
        while (d != 0){
            temp = d;
            d = c % d;
            c = temp;
            System.out.println("c="+ c +";     d=" + d);
        }
        System.out.println("Legnagyobb közös osztójuk:"+ c +"\n");
        return c;
    }

// A week08d05 csomagban készíts egy osztályt MathAlgorithms néven. Legyen benne egy
// metódus, greatestCommonDivisor() , ami paraméterül vár két pozitív egész számot
// és visszaadja a legnagyobb közös osztójukat.
// ->
// Felesleges külön keresni az osztóikat, aztán két rendezett listából egyezést keresni.
// Felesleges mindet kigyűjteni, mert ha egyre nagyobbakat találok, akkor az
// utolsó a legnagyobb.
// Vagy módszerek a Wikipédiáról.
}
