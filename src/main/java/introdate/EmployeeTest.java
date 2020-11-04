package introdate;
import java.util.Scanner;
public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("Alkalmazott neve:");
        Scanner sc = new Scanner(System.in);
        String eName = sc.nextLine();

        System.out.println("Születési éve:");
        int birthYear = sc.nextInt();
        sc.nextLine();
        System.out.println("Születés hónapja:");
        int birthMonth = sc.nextInt();
        sc.nextLine();
        System.out.println("Születés napja:");
        int birthDay = sc.nextInt();
        sc.nextLine();

        Employee employee1 = new Employee(birthYear,birthMonth,birthDay,eName);
        System.out.println("Adatok/n Neve: "+ employee1.getName());
        String writtenEpmloyment = ""+ employee1.getBeginEmployment();
        System.out.println("Alkalmazásban: "+ writtenEpmloyment.substring(0,16) +" óta");
        System.out.println("Született: " + employee1.getDateOfBirth());
    }
}
