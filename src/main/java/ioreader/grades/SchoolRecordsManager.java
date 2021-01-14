package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {
    private List<Student> students = new ArrayList<>();

    public void readGradesFromFile(String s) {
        Path file = Path.of(s);
        try (BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            while( (line = reader.readLine() ) != null){
                String[] studentArray = line.split(" ");
                List<Integer> notes = new ArrayList<>();
                for (int i = 1; i < studentArray.length; i++){
                    notes.add(Integer.parseInt(studentArray[i]));
                }
                System.out.println(studentArray[0] +" "+ notes.toString());
                students.add(new Student(studentArray[0], notes));
            }
        } catch (IOException | NumberFormatException e){
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public double classAverage(){
        double average = 0.0;
        for (Student s : students){
            average += s.average();
        }
        return average / students.size();
    }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }
}
