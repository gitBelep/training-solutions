package objects;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ObjectsMain {

    public static void main(String[] args) {
        new Book();
        System.out.println(new Book() +"  ez a sout(new Book)");

        Book emptyBook = null;
        System.out.println(emptyBook +"  null Book");

        Book book = new Book();
        System.out.println(book);

        book = null;
        System.out.println(book);

        book = new Book();
        System.out.println(book);

        Book anotherBook = new Book();
        System.out.println(book == anotherBook);

        anotherBook = book;
        System.out.println(anotherBook);
        System.out.println(book == anotherBook);
        System.out.println(anotherBook instanceof Book);

        System.out.println("Tömbök és kollekciók");
        Book[] books = {new Book(), new Book(), new Book()};

        List<Book> kollekcio1 = Arrays.asList(new Book(), new Book(), new Book());

        List<Book> kollekcio2 = new ArrayList<>();
        kollekcio2.add(new Book());
        kollekcio2.add(new Book());
        kollekcio2.add(new Book());
    }
}
