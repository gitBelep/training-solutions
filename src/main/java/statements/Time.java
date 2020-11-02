package statements;
public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds){
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

    public int getInMinutes(Time in){
        return in.getHours()*60+in.getMinutes();
    }
    public int getInSeconds(Time in){
        return in.getHours()*3600+in.getMinutes()*60+in.getSeconds();
    }
    public String toString(Time in){
        String h= ""+ in.getHours();
        String m= ":"+ in.getMinutes();
        String s= ":"+ in.getSeconds();
        return h+m+s;
    }
    public boolean earlierThan(Time in1,Time in2){
        return in1.getInSeconds(in1) < in2.getInSeconds(in2);
    }
}
