package genericsusage.withgenerics;

import genericsusage.Book;
import java.util.List;

public class Library {

    public Book getFirstBook(List<Book> books) {
        if (books == null) {
            throw new NullPointerException("");
        }
        if (books.size() == 0) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
//de ilyet nem is enged átadni paraméterként!
        if (books.get(0).getClass() != new Book("").getClass()) {
            throw new NullPointerException("Not a book");
        }
        return books.get(0);
    }
}
