package week04d01;

public class Fibonacci {
    public int getFibonacci(int n){
        if (n<=1){
            return n;
        }else{
            return getFibonacci(n-1)+getFibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        Fibonacci fibi = new Fibonacci();
        System.out.println("0 1 1 2 3 5 8 13 21 34 .. \nMethod nem magamtól, hanem Kristóf adta");
        System.out.print("7-nél: ");
        System.out.print(fibi.getFibonacci(7));
    }
}
