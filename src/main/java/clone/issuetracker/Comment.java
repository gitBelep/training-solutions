package clone.issuetracker;

import java.time.LocalDateTime;

public class Comment {
    private String text;
    private final LocalDateTime time;

    public Comment(String text, LocalDateTime time) {
        this.text = text;
        this.time = time;
    }

    public Comment(Comment other){
        text = other.text;
        time = other.time;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Comment text= " + text +" time= " + time;
    }

    public void setText(String text) {
        this.text = text;
    }
}
