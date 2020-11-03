package Statements2;
public class Time2 {
    private int hours;
    private int minutes;
    private int seconds;

    public Time2(int hours, int minutes, int seconds){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
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

    public int getInMinutes(){
        return getHours()*60+getMinutes();
    }
    public int getInSeconds(){
        return getHours()*3600+getMinutes()*60+getSeconds();
    }
    public String toString(){
        String h= ""+ getHours();
        String m= ":"+ getMinutes();
        String s= ":"+ getSeconds();
        return h+m+s;
    }
    public boolean earlierThan(Time2 in2){
        return getInSeconds() < in2.getInSeconds();
    }
}
