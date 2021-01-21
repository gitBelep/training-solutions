package objects;

public class Objektumokszama {

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        Book book4 = book1;
        Book book5 = book1;
        Book book6 = book3;
        Book book7 = null;

        book5 = new Book();
        book6 = null;
        System.out.println("Objektumok száma? 4 v 6, ha a null is új objektum");
    }
}
