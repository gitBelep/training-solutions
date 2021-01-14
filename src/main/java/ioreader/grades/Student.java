package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final List<Integer> gradeList;

    public Student(String name, List<Integer> gradeList) {
        this.name = name;
        this.gradeList = gradeList;
    }

    public double average() {
        double sum = 0.0;
        for (int i : gradeList) {
            sum += i;
        }
        return sum / gradeList.size();
    }

    public boolean isIncreasing() {
        if (gradeList == null || gradeList.size() < 2) {
            return false;
        }
        for (int i = 1; i < gradeList.size(); i++) {
            if (gradeList.get(i) < gradeList.get(i-1)){
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }
}
