package searching;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private int id;
    private final String title;
    private final String author;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    @Override
    public int compareTo(Book o){
        int result = this.author.compareTo(o.author);
        if (result == 0){
            result = this.title.compareTo(o.title);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return id +" "+ author +" "+title;
    }
}
