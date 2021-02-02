package sorting;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {
    Set<Book> library = new TreeSet<>();

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook() {
        if (library == null || library.isEmpty()) {
            throw new NullPointerException("Libray is empty!");
        }
        Iterator<Book> b = library.iterator();
        return b.next();
    }

}
