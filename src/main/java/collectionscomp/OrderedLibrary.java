package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {
    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle(){
        Set<Book> naturallyOrdered = new TreeSet<>(getBooks());
        return new ArrayList<>(naturallyOrdered);
    }

    public List<Book> orderedByAuthor(){
        List<Book> unordered = getBooks();
        unordered.sort(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getAuthor().compareTo(b2.getAuthor());
            }
        });
        return unordered;
    }

    public List<Book> getBooks() {
        return new LinkedList<>(libraryBooks);
    }

    public List<String> orderedByTitleLocale(Locale locale){
        List<String> ordered = new ArrayList<>();
        for (Book b : libraryBooks){
            ordered.add(b.getTitle());
        }
        Collator localeCollator = Collator.getInstance(locale);
        localeCollator.setStrength(Collator.PRIMARY);
        ordered.sort(localeCollator);
        return ordered;
    }

}
