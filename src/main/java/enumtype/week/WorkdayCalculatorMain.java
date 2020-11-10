package enumtype.week;

public class WorkdayCalculatorMain {

    public static void main(String[] args) {
        WorkdayCalculator calc = new WorkdayCalculator();
        System.out.println("Kezdődik a megadott \"Kedd\"-del: \n"+ calc.dayTypes(Day.KEDD, 12));
    }
}
