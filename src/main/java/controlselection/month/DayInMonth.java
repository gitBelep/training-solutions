package controlselection.month;
import java.util.Scanner;

public class DayInMonth {
    public static void main(String[] args) {
        System.out.println("add meg a hónap nevét:");
        Scanner sc = new Scanner(System.in);
        String month = sc.nextLine().toLowerCase();
        System.out.println("add meg az évet:");
        int year = sc.nextInt();
        DayInMonth dm = new DayInMonth();
        System.out.println(month + " "+ year +". évben "+ dm.howLongIsAMonth(year,month) +" nap hosszú.");
    }
        public int howLongIsAMonth(int year, String month){
            int n = 0;
            switch (month) {
                case "január":
                case "március":
                case "május":
                case "július":
                case "augusztus":
                case "október":
                    n = 31;
                case "december":
                    break;
                case "április":
                case "június":
                case "szeptember":
                case "november":
                    n = 30;
                    break;
                case "február":
                    n = 28;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid month: " + month);
            }
        if ((n == 28) && (year % 4 == 0)){
            n = 29;
            if ((year % 400 != 0) && (year % 100 == 0)){
                n = 28;
            }
        }
        return n;
    }
}
