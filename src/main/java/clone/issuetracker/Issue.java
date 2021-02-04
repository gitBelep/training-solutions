package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {
    List<Comment> comments = new ArrayList<>();
    private final String name;
    private final LocalDateTime time;
    private final Status status;

    public Issue(String name, LocalDateTime time, Status status,List<Comment> comments) {
        this.name = name;
        this.time = time;
        this.status = status;
        this.comments = comments;
    }

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
    }

    public Issue (Issue i, CopyMode mode){
        this.name = i.name;
        this.time = i.time;
        this.status = i.status;
        if (mode == CopyMode.WITHOUT_COMMENTS){
            this.comments = new ArrayList<>();
        } else {
//comments-be másolatokat kell tenni, hogy külön változtathatóak legyenek az új Issue-ban!
            List<Comment> creator =  new ArrayList<>();
            for (Comment c : i.comments ){
                creator.add(new Comment(c));
            }
            this.comments = creator;
        }
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

}
