package schoolrecords;

public class Subject {
    private String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return String.format("%s", subjectName);
    }

}
