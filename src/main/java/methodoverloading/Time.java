package methodoverloading;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

//    Konstruktorok:
    public Time(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public Time(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
    }
    public Time(int hours){
        this.hours = hours;
    }
    public Time(Time time) { }

//    Publikus metódusok:
    public boolean isEqual(Time time){
        return (hours == time.hours && minutes == time.minutes && seconds == time.seconds);
    }

    public boolean isEqual(int hours, int minutes, int seconds){
        return (hours == this.hours && minutes == this.minutes && seconds == this.seconds);
    }

    public boolean isEarlier(Time time){
        int timeInSec = (time.hours*360)+(time.minutes*60)+time.seconds;
        int thisInSec = (hours * 360) + (minutes * 60) + seconds;
        return thisInSec < timeInSec;
    }

    public boolean isEarlier(int hours, int minutes, int seconds){
        int thisInSec = (this.hours*360)+(this.minutes*60)+this.seconds;
        int incomeInSec = (hours * 360) + (minutes * 60) + seconds;
        return thisInSec < incomeInSec;
    }

    public int getHours() {
        return hours;
    }
    public int getMinutes() {
        return minutes;
    }
    public int getSeconds() {
        return seconds;
    }
}
