package intromethods.employee;

public class Employee {
    private String name;
    private int hireingYear;
    private int salary;

    public Employee(String name, int hireingYear, int salary) {
        this.name = name;
        this.hireingYear = hireingYear;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getHireingYear() {
        return hireingYear;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void raiseSalary(int amount) {
        salary = salary + amount;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "name='" + name + '\'' +
            ", hiringYear=" + hireingYear +
            ", salary=" + salary +
            '}';
    }

}
