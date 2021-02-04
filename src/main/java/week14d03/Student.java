package week14d03;

import java.util.*;

public class Student implements Comparable<Student>{
    private final String name;
    private Map<String, List<Integer>> notes = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public void giveMark(String fact, int note){
        if(!notes.containsKey(fact)) {
            notes.put(fact, new ArrayList<>());
        }
        notes.get(fact).add(note);
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    public Map<String, List<Integer>> getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return name + notes;
    }

    public String getName() {
        return name;
    }
}
