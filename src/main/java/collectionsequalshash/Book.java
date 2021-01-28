package collectionsequalshash;

import java.util.Objects;
//ha kikommentelem a
//hash-t: Set nem látja az azonosságot
//equals-t: nem tud összehasonlítani, .contains(), .indexOf()

public class Book {
    private String regNumber;
    private final String author;
    private final String title;

    public Book(String title, String author) {
        this.author = author;
        this.title = title;
    }

    public Book(String regNumber, String title, String author) {
        this(title, author);
        this.regNumber = regNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return author.equals(book.author) && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "regNumber='" + regNumber + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
