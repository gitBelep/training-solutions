package schoolrecords;
import java.util.*;

public class SchoolRecordsController {
    private ClassRecords cRecords;
    List<Subject> subjectList = new ArrayList<>();
    List<Tutor> tutorList = new ArrayList<>();
    private static boolean end;
    static Scanner sc = new Scanner(System.in);


    public SchoolRecordsController(ClassRecords cRecords) {
        this.cRecords = cRecords;
    }

    public void initSchool(ClassRecords crr) {
        Tutor tutor = new Tutor("Nagy Csilla", Arrays.asList(new Subject("földrajz"),new Subject("matematika"), new Subject("biológia"), new Subject("zene"),
                        new Subject("fizika"), new Subject("kémia")));
        tutorList.add(tutor);
        subjectList = List.of(new Subject("földrajz"), new Subject("kémia"), new Subject("matematika"), new Subject("biológia"), new Subject("zene"));
        List almos = List.of(subjectList.get(0), subjectList.get(3));
        tutorList.add(new Tutor("Álmos", almos));
        List elod = List.of(subjectList.get(1), subjectList.get(2));
        tutorList.add(new Tutor("Előd", elod));
        Student firstStudent = new Student("Kovács Rita");
        Student secondStudent = new Student("Nagy Béla");
        Student thirdStudent = new Student("Varga Márton");
        firstStudent.grading(new Mark(MarkType.B, new Subject("földrajz"), tutor));
        firstStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
        firstStudent.grading(new Mark(MarkType.F, new Subject("földrajz"), tutor));
        secondStudent.grading(new Mark(MarkType.A, new Subject("biológia"), tutor));
        secondStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
        secondStudent.grading(new Mark(MarkType.D, new Subject("zene"), tutor));
        thirdStudent.grading(new Mark(MarkType.A, new Subject("fizika"), tutor));
        thirdStudent.grading(new Mark(MarkType.A, new Subject("kémia"), tutor));
        thirdStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
        crr.addStudent(firstStudent);
        crr.addStudent(secondStudent);
        crr.addStudent(thirdStudent);
    }

    public void printMenu() {
        System.out.println("OK 1. Diákok nevének listázása\n" +
                "   2. Diák név alapján keresése\n" +
                "   3. Diák létrehozása\n" +
                "   4. Diák név alapján törlése\n" +
                "   5. Diák feleltetése\n" +
                "OK 6. Osztályátlag kiszámolása\n" +
                "OK 7. Tantárgyi átlag kiszámolása\n" +
                "OK 8. Diákok átlagának megjelenítése\n" +
                "   9. Diák átlagának kiírása\n" +
                "   10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                "OK 11. Kilépés");
    }
    public void choseMenu(String chosen, ClassRecords crr){
        switch(chosen){
            case "1":
                System.out.println(crr.listStudentNames()+" \n");
                break;
            case "2": ;
                break;
            case "3": ;
                break;
            case "4": ;
                break;
            case "5": ;
                break;
            case "6":
                System.out.println("Osztályátlag "+ subjectList.toString());
                System.out.println(crr.calculateClassAverage());
                break;
            case "7":
                seventh();
                break;
            case "8":
                eighth();
                break;
            case "9": ;
                break;
            case "10": ;
                break;
            case "11": end = true;
                break ;
        }
    }

    public void seventh(){
        System.out.println("Tantárgy? "+ subjectList.toString());
        String subject = sc.nextLine();
        for (Subject subjectObj : subjectList){
            if (subjectObj.getSubjectName().equals(subject)){
                System.out.println(cRecords.calculateClassAverageBySubject(subjectObj) +"\n");
                return;
            }
        }
    }

    public void eighth(){
        List<StudyResultByName> list = cRecords.listStudyResults();
        for (StudyResultByName s : list) {
            System.out.printf("%s: %1.2f; ", s.getStudentName(), s.getStudyAverage());
        }
        System.out.println("\n");
        return;
    }

    public void listStudentNames(){
        cRecords.listStudentNames();
    }
//    Diák név alapján keresése - bekéri a diák nevét, és a diák szöveges reprezentációját írja ki (findStudentByName())
//    Diák létrehozása - bekéri a diák nevét, és felviszi (new Student(), valamint addStudent())
//    Diák név alapján törlése - be kell kérni a nevét, és az első találatot törölni (először egy findStudentByName() majd egy removeStudent() hívás)
//    Diák feleltetése - előbb sorsolni kell egy diákot, meg kell hívni a repetition() metódust, bekérni az érdemjegyet, tárgy nevét, oktató nevét. A tárgyat és az oktatót kikeresni a listából, példányosítani ezekkel egy Mark-ot, és meghívni a grading() metódust.
//    Diákok átlagának megjelenítése - listStudyResults() eredményének kiírása
//    Diák átlagának kiírása - be kell kérni a nevét, findStudentByName(), majd az eredményen calculateAverage()
//    Diák tantárgyhoz tartozó átlagának kiírása - be kell kérni a nevét, majd a tantárgy nevét. findStudentByName(), majd ki kell keresni a tantárgyat a listából, majd calculateSubjectAverage(Subject) hívás

    public static void main(String[] args) {
        ClassRecords crr = new ClassRecords("1a", new Random(7));
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController( crr );
        schoolRecordsController.initSchool(crr);
        do {
            schoolRecordsController.printMenu();
            schoolRecordsController.choseMenu(sc.nextLine(), crr);
        } while ( !end);

    }

}
