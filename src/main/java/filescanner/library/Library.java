package filescanner.library;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void loadFromFile() {
        try (Scanner sc = new Scanner(Library.class.getResourceAsStream("/books.csv"))) {
            sc.useDelimiter(";|(\n)");

            while (sc.hasNext()) {
                String inventoryNr = sc.next();
                String author = sc.next();
                String title = sc.next();
                int year = sc.nextInt();
                sc.nextLine();
                books.add(new Book(inventoryNr, author, title, year));
            }
        }
    }

//    public static void main(String[] args) {
//        Library libb = new Library();
//        libb.loadFromFile();
//        System.out.println(libb.getBooks().get(1).getAuthor());
//        System.out.println(libb.getBooks().get(0).getTitle());
//        System.out.println(libb.getBooks().get(2).getAuthor());
//        System.out.println(libb.getBooks().get(2).getYear());
//        System.out.println(libb.getBooks().get(0).getYear());
//    }
}
