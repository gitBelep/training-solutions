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
        if (students.size() == 0){
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double studentsSubjAvg = 0.0;
        int numOfStudents = 0;
        for (Student ss : students){
            if (ss.hasMarkInSubject(subject)){
            studentsSubjAvg = studentsSubjAvg + ss.calculateSubjectAverage(subject);
            numOfStudents++;
            }
        }
        if (studentsSubjAvg == 0.0){
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return  ((double) Math.round(studentsSubjAvg * 100 / numOfStudents)) /100;
    }

    public Student findStudentByName(String name){
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.size() == 0){
            throw new IllegalStateException("No students to search!");
        }
        for (Student ss : students){
            if(ss.getName().equals(name)){
                return ss;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    //felelethez a listából random módon kiválaszt egy diákot
    public Student repetition(){
        if (students.size() == 0){
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));
    }
//a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,s azok listáját adja vissza
    public List<StudyResultByName> listStudyResults(){
        List<StudyResultByName> list = new ArrayList<>();
        for (Student ss: students){
            StudyResultByName srn = new StudyResultByName(ss.getName(), ss.calculateAverage());
            list.add(srn);
        }
        return list;
    }

    public String listStudentNames(){
        List<String> names = new ArrayList<>();
        for (Student ss : students){
            names.add(ss.getName());
        }
        String result = names.toString();
        result = result.substring(1, result.length()-1);
        return result;
    }

    public String getClassName() {
        return className;
    }
    public Random getRnd() {
        return rnd;
    }
    private boolean isEmpty(String str){
        return "".equals(str.trim());
    }
}
