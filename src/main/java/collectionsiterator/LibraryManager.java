package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {
    private Set<Book> books = new HashSet<>();

    public LibraryManager(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return new HashSet<>(books);
    }

    public Book findBookByRegNumber(int regNumber){
        Iterator<Book> b = books.iterator();
        while (b.hasNext()){
            Book actual = b.next();
            if (actual.getRegNumber() == regNumber){
                return actual;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber){
        for (Iterator<Book> i = books.iterator(); i.hasNext(); ) {
            Book actual = i.next();
            if (actual.getRegNumber() == regNumber) {
                i.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: "+regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author){
        Set<Book> result = new HashSet<>();
        Iterator<Book> i = books.iterator();
        while(i.hasNext()){
            Book actual = i.next();
            if (actual.getAuthor().equals(author)){
                result.add(actual);
            }
        }
        if (result.size() > 0) {
            return result;
        }
        throw new MissingBookException("No books found by "+ author);
    }

    public int libraryBooksCount(){
        return books.size();
    }
}
