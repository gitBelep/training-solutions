package arrayofarrays;
import java.util.Scanner;

public class ArrayOfArraysMain {

        public int[][] multiplicationTable(int size){
            int[][] table = new int[size+1][size+1];
            for (int i=1; i<= size; i++) {
                for (int j = 1; j <= size; j++) {
                    table[i][j] = i * j;
                    System.out.print(table[i][j] +" ");
                }
                System.out.println();
            }
            return table;
        }

    public void printArrayOfArrays(int[][] a){
        for (int i=0; i< a.length; i++) {
            int j=0;
            for (j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] +" ");
            }
            System.out.println();
        }
    }

    public int[][] triangularMatrix(int size){
            int[][] tr = new int[size][];
            for (int i=0; i<size; i++){
                int j =0;
                tr[i] = new int[i+1];
                for (j=0; j<i+1; j++){
                    tr[i][j] = i;
                    System.out.print(i +" ");
                }
                System.out.println();
            }
            return tr;
    }

    public static void main(String[] args) {
        System.out.println("Mekkora legyen a szorzótábla?");
        Scanner sc = new Scanner(System.in);
        int siz = sc.nextInt();
        ArrayOfArraysMain a = new ArrayOfArraysMain();
        a.multiplicationTable(siz);

        System.out.println(" - - - ");
        int[][] secondArr={{8, 8, 9, 8, 9},{1},{45, 56},{0, 900, 0},{111}};
        a.printArrayOfArrays(secondArr);

        sc.nextLine();
        System.out.println("Hány soros legyen a háromszögmátrix?");
        int trSiz = sc.nextInt();
        a.triangularMatrix(trSiz);
        }
}
