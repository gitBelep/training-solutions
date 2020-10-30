package classsctructureconstructors;

import java.util.Scanner;

public class StoreMain {
    public static void main(String[] args) {
        System.out.println("Első Terméked:");
        Scanner sc1 = new Scanner(System.in);
        String name1 = sc1.nextLine();
        Store store1 = new Store(name1);

        System.out.println("Második Terméked:");
     //   Scanner sc2 = new Scanner(System.in);
        String name2 = sc1.nextLine();
        Store store2 = new Store(name2);

        System.out.println("Készletnövelés " + store1.getProduct() );
     //   Scanner sc3 = new Scanner(System.in);
        int sc13 = sc1.nextInt();
        store1.store(sc13);

        System.out.println("Készletnövelés " + store2.getProduct() );
    //    Scanner sc4 = new Scanner(System.in);
        int sc14 = sc1.nextInt();
        store2.store(sc14);

        System.out.println("Kiszállítás " + store1.getProduct() );
     //   Scanner sc5 = new Scanner(System.in);
        int sc15 = sc1.nextInt();
        store1.dispatch(sc15);

        System.out.println("Kiszállítás " + store2.getProduct() );
     //   Scanner sc6 = new Scanner(System.in);
        int sc16 = sc1.nextInt();
        store2.dispatch(sc16);

        System.out.println(store1.getProduct() +": " + store1.getStock());
        System.out.println(store2.getProduct() +": " + store2.getStock());

    }
}
