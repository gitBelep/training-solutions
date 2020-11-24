package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> subjectsOfTutor = new ArrayList<>();

    public Tutor(String name, List<Subject> subjectsOfTutor) {
        this.name = name;
        this.subjectsOfTutor = subjectsOfTutor;
    }

    public boolean tutorTeachingSubject(Subject subject){
        boolean found = false;
        for (Subject s:subjectsOfTutor) {
            if (s.getSubjectName() == subject.getSubjectName()) {
                found= true;
            }
        }
        return found;
    }

    public String getName() {
        return name;
    }
}
