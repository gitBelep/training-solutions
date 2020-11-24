package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> students= new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public boolean addStudent(Student student){
        List<String> studentsNamelist = new ArrayList<>();
        for (Student ss : students){
            studentsNamelist.add(ss.getName());
        }
        if (students.size() == 0) {
            students.add(student);
            return true;
        } else if (studentsNamelist.contains(student.getName())){
            return false;
        } else {
            students.add(student);
            return true;
        }
    }

    public boolean removeStudent(Student student){
        for (Student ss : students){
            if (ss.getName().equals(student.getName())){
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public double calculateClassAverage(){
        if (students.size() == 0){
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double studentsAvgList = 0.0;
        for (Student ss : students){
            studentsAvgList = studentsAvgList + ss.calculateAverage();
        }
        if (studentsAvgList == 0.0){
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return  ((double) Math.round(studentsAvgList * 100 / students.size())) /100;
    }

// kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye
    public double calculateClassAverageBySubject(Subject subject){
//        if (students.size() == 0){
//            throw new ArithmeticException("No student in the class, average calculation aborted!");
//        }
        double studentsSubjAvg = 0.0;
        for (Student ss : students){
//            if (ss)
//            studentsSubjAvg = studentsSubjAvg + ss.calculateSubjectAverage();
        }
        if (studentsSubjAvg == 0.0){
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return  ((double) Math.round(studentsSubjAvg * 100 / students.size())) /100;
    }
//    public Student findStudentByName(String name){} // név szerint megkeres egy diákot az osztályban
//    public Student repetition(){} //felelethez a listából random módon kiválaszt egy diákot
//    public List<StudyResultByName> listStudyResults(){} //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
//    // és azok listáját adja vissza
//    public String listStudentNames(){} //kilistázza a diákok neveit, vesszővel elválasztva
//
//    private boolean isEmpty(String str){}

    public String getClassName() {
        return className;
    }
    public Random getRnd() {
        return rnd;
    }
}
