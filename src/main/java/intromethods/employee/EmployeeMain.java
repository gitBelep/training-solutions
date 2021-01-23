package intromethods.employee;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee = new Employee("Maminti Jolán", 2000, 400_000);
        System.out.println(employee);

        employee.raiseSalary(20000);
        System.out.println("Emelés után: "+ employee);

        employee.setName("Kissné Jolán");
        System.out.println("Név: " + employee.getName());
        System.out.println("Felvétel éve: " + employee.getHireingYear());
        System.out.println("Fizu:" + employee.getSalary());
    }

}
