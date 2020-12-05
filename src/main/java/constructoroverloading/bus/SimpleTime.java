package constructoroverloading.bus;

public class SimpleTime {
    private int hours;
    private int minutes;
    private static int defaultMinutes = 0;


    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this.hours = hours;
        this.minutes = defaultMinutes;
    }

    public SimpleTime(SimpleTime time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
    }

    public int difference(SimpleTime time){
        return (hours*60 + minutes)-(time.hours*60 + time.minutes);
    }

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }

    public int getHours() {
        return hours;
    }
    public int getMinutes() {
        return minutes;
    }
    public int getInMinutes() { return hours*60 + minutes; }
}