package catalog;

import java.util.ArrayList;
import java.util.List;

public class PrintedFeatures implements Feature {
    private List<String> authors = new ArrayList<>();
    private int numberOfPages;
    private String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (numberOfPages <= 0){
            throw new IllegalArgumentException("Invalid Number Of Pages");
        }
        this.numberOfPages = numberOfPages;

        if (Validators.isBlank(title)){
            throw new IllegalArgumentException("Empty title");
        }
        this.title = title;

        if (Validators.isEmpty(authors)){
            throw new IllegalArgumentException("Without author");
        }
        this.authors = authors;
    }

    @Override
    public List<String> getContributors() {
        return authors;
    }

    @Override
    public String getTitle() {
        return title;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
}
