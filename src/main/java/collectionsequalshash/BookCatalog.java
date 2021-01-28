package collectionsequalshash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author){
        Book book = new Book("", title, author);
        for (Book b : books){
            if (b.equals(book)){
                return b;
            }
        }
        return null;
    }

//működik a .contains(Obj) és a .indexOf(Obj)
    public Book findBook(List<Book> books, Book book){
       if (books.contains(book)) {
           int bookPlace = books.indexOf(book);
            return books.get(bookPlace);
        }
        return null;
    }

    public Set<Book> addBooksToSet(Book[] books){
        Set<Book> result = new HashSet<>();
        for (Book b : books) {
            result.add(b);
        }
        return result;
    }

}
