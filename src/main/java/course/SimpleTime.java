package course;

public class SimpleTime {
    private int minute;
    private int hour;

    public SimpleTime(int hour, int minute) {
        if ( checkHourAndMinute(hour, minute) ) {
            this.hour = hour;
            this.minute = minute;
        }
    }

    public SimpleTime(String str) {
        if (str == null || str.length()==0){
            throw new InvalidTimeException("Time is null");
        }
        if (str.indexOf(":") < 1 || 2 < str.indexOf(":")){
            throw new InvalidTimeException("Time is not hh:mm");
        }

        String time[] = str.split(":");
        int h = -1;
        int min = -1;

        try {
            h = Integer.parseInt(time[0]);
            min = Integer.parseInt(time[1]);
        } catch (NumberFormatException nfe){
            throw new InvalidTimeException("Time is not hh:mm");
        }
        if ( checkHourAndMinute(h, min) ) {
            this.hour = h;
            this.minute = min;
        }
    }

    private boolean checkHourAndMinute(int hour, int minute){
        if (hour < 0 || 23 < hour){
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || 59 < minute){
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        return true;
    }

        @Override
    public String toString() {
        return new String(String.format("%02d:%02d", hour, minute));
    }

    public int getMinute() {
        return minute;
    }
    public int getHour() {
        return hour;
    }
}
