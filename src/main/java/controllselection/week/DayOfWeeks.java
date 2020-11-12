package controllselection.week;
import java.util.Scanner;

public class DayOfWeeks {
    public static void main(String[] args) {
        System.out.println("add meg a nap nevét:");
        Scanner sc = new Scanner(System.in);
        String day = sc.nextLine().toLowerCase();
        DayOfWeeks dw = new DayOfWeeks();
        System.out.println(day +" minősítése: "+ dw.dayOfWeek(day));
    }

    public String dayOfWeek(String day){
        String qualifying;
        switch (day){
            case "hétfő":
                qualifying = "hét eleje";
                break;
            case "kedd":
            case "szerda":
            case "csütörtök":
                qualifying = "hét közepe";
                break;
            case "péntek":
                qualifying= "majdnem hétvége";
                break;
            case "szombat":
            case "vasárnap":
                qualifying = "hét vége";
                break;
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
        return qualifying;
    }
}
