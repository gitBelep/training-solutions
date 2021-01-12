package week11d02;

public class Ride {
        private final int day;
        private final int round;
        private final int km;

    public Ride(int day, int ride, int km) {
        if (day < 1 || 7 < day){
            throw new IllegalArgumentException("Incorrect day");
        }
        this.day = day;
        if (ride  < 1 ){
            throw new IllegalArgumentException("Incorrect number");
        }
        this.round = ride;
        if (km  < 1 ){
            throw new IllegalArgumentException("Incorrect distance");
        }
        this.km = km;
    }

    public int getDay() {
        return day;
    }

    public int getRound() {
        return round;
    }

    public int getKm() {
        return km;
    }
}
