package array;

import java.util.Scanner;

public class ArrayHandler {

    boolean contains(int[] source, int itemToFind){
        for (int i=0; i<source.length; i++){
            if (itemToFind != source[i]){
                continue;
            }else{
                return true;
            }
        }
        return false;
    }

    int find(int[] source, int itemToFind){
        for (int i=0; i<source.length; i++){
           if (itemToFind != source[i]){
               continue;
           }else{
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayHandler ar = new ArrayHandler();
        int so[] = {2, 3, 4, 5, 10, 9, 8, 11, 0};
        System.out.println("Keresett szám:");
        Scanner sc = new Scanner(System.in);
        int toFind = sc.nextInt();

        System.out.println(ar.contains(so, toFind)?"Van: "+ar.find(so, toFind) +"-ik helyen":"Nincs");
    }
}
