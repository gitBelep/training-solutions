package filescanner.library;

public class Book {
    private String inventoryNr;
    private String author;
    private String title;
    private int year;

    public Book(String inventoryNr, String author, String title, int year) {
        this.inventoryNr = inventoryNr;
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getInventoryNr() {
        return inventoryNr;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
