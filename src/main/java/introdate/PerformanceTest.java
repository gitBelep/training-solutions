package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {
    public static void main(String[] args) {
        LocalDate pDate = LocalDate.of(1985,7,13);
        LocalTime pStartTime = LocalTime.of(20,01);
        LocalTime pEndTime = LocalTime.of(22,02);

        Performance performance = new Performance(pDate,pStartTime, pEndTime, "Queen");
        System.out.println(performance.getInfo());
    }
}
