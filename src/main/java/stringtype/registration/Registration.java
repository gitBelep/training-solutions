package stringtype.registration;
import java.util.Scanner;
public class Registration {
    public static void main(String[] args) {
        System.out.println("Felhasználóneved:");
        Scanner sc = new Scanner(System.in);
        String uName = sc.nextLine();

        System.out.println("Jelszó:");
        String uPsw1 = sc.nextLine();
        System.out.println("Jelszó újra:");
        String uPsw2 = sc.nextLine();

        System.out.println("E-mail címed:");
        String uEmail = sc.nextLine();

        UserValidator u1 = new UserValidator(uName,uPsw1,uPsw2,uEmail);
        System.out.println(u1.isOkName()?"Név rendben":"Nem megfelelő név");
        System.out.println(u1.isOkPsw()?"Jelszó rendben":"Nem megfelelő jelszó");
        System.out.println(u1.isOkEmail()?"E-mail rendben":"Nem megfelelő e-mail");
    }
}
