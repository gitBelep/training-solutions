package defaultconstructor.date;
import java.util.List;

public class SimpleDate {
    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (isCorrectYear(year) && isCorrectMonth(month) && isCorrectDay(day, month, year)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! "+
                    year +", "+ month +", "+ day);
        }
    }

    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    private boolean isCorrectYear(int year) {
        if (year < 1900) {
            return false;
        }
        return true;
    }

    private boolean isCorrectMonth(int month) {
        if (month < 1 || month > 12) {
            return false;
        }
        return true;
    }

    private boolean isCorrectDay(int day, int month, int year) {
        if (day < 1){
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        List<Integer> longMonth = List.of(1, 3, 5, 7, 8, 10, 12);
        return ( day <= 30 || (day == 31 && longMonth.contains((Integer) month)) );
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 !=0 ) || year % 400 ==0;
    }

}
