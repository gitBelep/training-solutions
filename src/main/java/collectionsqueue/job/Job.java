package collectionsqueue.job;

public class Job implements Comparable{
    private final int priority;          // 1 - 10 skálán osztályozzuk a prioritást
    private final String jobDescription;
    private final boolean urgent;        // true, ahol a prioritás < 5

    public Job(int priority, String jobDescription) {
        this.priority = priority;
        this.jobDescription = jobDescription;
        urgent = (priority < 5);
    }

    @Override
    public int compareTo(Object other) {   //Job other, class ell. nem kell
        if (!this.getClass().equals(other.getClass())){
            throw new NoJobException("No job available, get a rest!");
        }
        return this.priority - ((Job) other).getPriority();
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }
}
