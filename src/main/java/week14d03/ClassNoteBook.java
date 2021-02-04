package week14d03;

import collectionscomp.Book;

import java.text.Collator;
import java.util.*;

public class ClassNoteBook {
    List<Student> students = new ArrayList<>();

    public ClassNoteBook(List<Student> students) {
        this.students = students;
    }

    public List<Student> sortNotebook(){
        List<Student> result = new ArrayList<>(students);
//        Collator localeCollator = Collator.getInstance(new Locale("hu", "HU"));
//        localeCollator.setStrength(Collator.PRIMARY);
//        Collections.sort(result, localeCollator);
// Nem rendez Student Listát, csak List<String>-et.
        Collections.sort(result);
        return result;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
