package week07d04;
import java.time.LocalDate;

public class Lab {
    private String title;
    private boolean completed;
    private LocalDate completedAt;

    public Lab(String title) {
        this.title = title;
    }

    public Lab(String title, LocalDate completedAt) {
        this.title = title;
        completed = true;
        this.completedAt = completedAt;
    }

    public void complete(LocalDate date){
        completed = true;
        this.completedAt = date;
    }

    public void complete(){
        completed = true;
        completedAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Lab{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                ", completedAt=" + completedAt +
                '}';
    }

    public String getTitle() {
        return title;
    }
    public boolean isCompleted() {
        return completed;
    }
    public LocalDate getCompletedAt() {
        return completedAt;
    }
}
