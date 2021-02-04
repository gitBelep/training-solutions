package week14d03;

import java.text.Collator;
import java.util.*;

public class ClassNoteBook {
    List<Student> students = new ArrayList<>();

    public ClassNoteBook(List<Student> students) {
        this.students = students;
    }

    public List<Student> sortNotebook() {
        List<Student> result = new ArrayList<>(students);
        result.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                Collator localeCollator = Collator.getInstance(new Locale("hu", "HU"));
                return localeCollator.compare(s1.getName(), s2.getName());
            }
        });
        return result;
    }

//Collator localeCollator = Collator.getInstance(new Locale("hu", "HU"));
//result.sort(localeCollator);  // Nem rendez Student Listát, csak List<String>-et.

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
