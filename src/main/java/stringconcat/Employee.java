package stringconcat;

public class Employee {
    private String name;
    private String job;
    private int salary;

    public Employee(String name, String job, int salary) {
        if(name == null || "".equals(name)){
            throw new IllegalArgumentException("Name must not be empty.");
        }
        if(job == null || "".equals(job)){
            throw new IllegalArgumentException("Job must not be empty.");
        }
        if (salary < 0 || (salary/1000)*1000 != salary){
            throw new IllegalArgumentException("Salary must be positive.");
        }
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return name +" - "+ job +" - "+ salary +" Ft";
    }
}
