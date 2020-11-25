package schoolrecords;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if (name == null){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (name.isEmpty()){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // érdemjegy rögzítése
    public void grading(Mark mark){
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(0, mark);
    }
    // teljes átlag számolása
    public double calculateAverage(){
        double fullAvg = 0.0;
        int sum = 0;
        int i = 0;
        if (marks.size() ==0){
            return fullAvg;
        }
        for (Mark m: marks){
            sum = sum + m.getMarkType().getValue();
            i++;
        }
        fullAvg = ((double) Math.round(sum*100/i)) /100;
        return fullAvg;
    }
    // tantárgyhoz tartozó átlag számítása
    public double calculateSubjectAverage(Subject subject){
        double avg = 0.0;
        int sum = 0;
        int i = 0;
        if (marks.size() ==0){
            return avg;
        }
        for (Mark m: marks){
            if (m.getSubject().getSubjectName() == subject.getSubjectName()) {
                sum = sum + m.getMarkType().getValue();
                i++;
            }
        }
        if (sum ==0){
            return avg;
        }
        avg = ((double) Math.round(sum*100/i)) /100;
        return avg;
    }

    boolean hasMarkInSubject(Subject sub){
        for (Mark mm : marks){
            if (mm.getSubject().getSubjectName().equals(sub.getSubjectName())){
                return true;
            }
        }
        return false;
    }

    private boolean isEmpty(String str){
        return "".equals(str.trim());
    }
    @Override  //"Kovács marks: matematika: excellent(5)"
    public String toString() {
        return String.format("%s marks: %s: %s", name, marks.get(0).getSubject(), marks.get(0).toString() );
    }
}
