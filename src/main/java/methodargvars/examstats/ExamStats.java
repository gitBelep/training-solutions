package methodargvars.examstats;

public class ExamStats {
    private int max;

    public ExamStats(int max){
        this.max = max;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results){
        ifEmpty(results);
        int limit = max * limitInPercent /100;
        int numberOfTopGrades = 0;
        for (int i : results){
            if (i > limit){
                numberOfTopGrades++;
            }
        }
        return numberOfTopGrades;
    }


    public boolean hasAnyFailed(int limitInPercent, int... results){
        ifEmpty(results);
        int limit = max * limitInPercent /100;
        for (int i : results){
            if (i < limit){
                return true;
            }
        }
        return false;
    }

    private void ifEmpty(int[] j){
        if ( j == null || j.length == 0){
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
    }
}
