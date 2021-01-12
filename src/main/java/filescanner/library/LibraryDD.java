package filescanner.library;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryDD {
    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() { return books; }

    public void loadFromFile(){
        Scanner sc = null;
        try {
            sc = new Scanner(Path.of("D:/books.txt"));
        }catch (IOException ioe) {
            System.out.println("file?");
        }
        while (sc.hasNextLine()) {
            String row = sc.nextLine();
            String inventoryNr = row.substring(0, row.indexOf(";"));
            String rest = row.substring(inventoryNr.length() + 1);
            String author = rest.substring(0, rest.indexOf(";"));
            rest = rest.substring(author.length() + 1);
            String title = rest.substring(0, rest.indexOf(";"));
            rest = rest.substring(title.length() + 1, title.length() + 5);
            int year = 0;
            try {
                year = Integer.parseInt(rest);
            } catch (NumberFormatException nf) {
                System.out.println(rest);
            }
            books.add(new Book(inventoryNr, author, title, year));
        }
        sc.close();
    }
}
