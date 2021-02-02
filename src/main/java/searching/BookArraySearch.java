package searching;

import java.util.Arrays;

public class BookArraySearch {
    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title){
        if (author == null || title == null || "".equals(author.trim()) || "".equals(title.trim())){
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        Arrays.sort(bookArray);
        Book searching = new Book(0,author, title); //Nem veheti figyelembe az id-t, megtalálja dummy id-vel.
        int indexOfTheBook = Arrays.binarySearch(bookArray, searching);
        if (indexOfTheBook < 0){
            throw new IllegalArgumentException("No book found by "+ author +" with title "+ title);
        }
        return bookArray[indexOfTheBook];
    }

}
