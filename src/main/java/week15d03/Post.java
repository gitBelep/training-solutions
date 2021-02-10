package week15d03;

import java.time.LocalDate;

public class Post {
    private final String owner;
    private final LocalDate publishedAt;
    private final String title;
    private final String content;

    public Post(String owner, LocalDate publishedAt, String title, String content) {
        this.owner = owner;
        this.publishedAt = publishedAt;
        this.title = title;
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return owner +" "+ publishedAt +" "+ title +" "+ content;
    }
}
