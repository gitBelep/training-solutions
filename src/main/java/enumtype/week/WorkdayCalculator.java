package enumtype.week;
import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    private Day[] dayList = Day.values();

    private Day nextDay(Day day){
        if (day.ordinal() == 6){
            Day nextDay = dayList[0];
            return nextDay;
        }else{
            Day nextDay = dayList[day.ordinal() + 1];
            return nextDay;
        }
    }

    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        int index = firstDay.ordinal();
        List<DayType> result = new ArrayList<>();
        result.add(firstDay.getDayType());
        for (int i = 0; i <= numberOfDays; i++) {
            result.add(nextDay(dayList[(index+i)%7]).getDayType());
        }
        return result;
    }
}
