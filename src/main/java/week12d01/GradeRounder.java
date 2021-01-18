package week12d01;

public class GradeRounder {
    public int[] roundGrades(int[] grades) {
        if (grades == null || grades.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        int[] rounded = new int[grades.length];

        for (int i = 0; i < grades.length; i++) {
            int actual = grades[i];
            if (actual < 0 || 100 < actual) {
                throw new IllegalArgumentException("Illegal grade");
            } else {
                rounded[i] = count(actual);
            }
        }
        return rounded;
    }

    private int count(int actual){
        if (actual < 40 || actual % 5 < 3){
            return actual;
        } else {
            return ((actual / 5) + 1) * 5;
        }
    }

}
