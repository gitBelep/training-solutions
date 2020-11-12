package week03;
import java.util.Scanner;

public class PhoneParser {
    public static void main(String[] args) {
        System.out.println("Telefonszámod: ( XX-XXXXXXXX )");
        Scanner sc = new Scanner(System.in);
        String getNr = sc.nextLine();

        PhoneParser par = new PhoneParser();
        Phone phone = par.parsePhone(getNr);

        System.out.println(phone.toString());
    }

    public Phone parsePhone(String s){
        String prefix = s.substring(0,s.indexOf("-"));
        String number = s.substring(s.indexOf("-")+1);
        return new Phone(prefix,number);
    //    Phone p = new Phone(prefix,number);
    //    return p;
    }
}
