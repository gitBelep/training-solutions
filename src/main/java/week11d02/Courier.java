package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    private final List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {  //kiszerveztem, hosszú volt
        if (ride == null) {
            throw new IllegalArgumentException("Ride is null");
        }
        int a = rides.size();
        if (a == 0) {
            addFirstRide(ride);
        } else {
            addAnotherRide(ride);
        }
    }

    private void addFirstRide(Ride ride){
        if (ride.getRound() == 1) {
            rides.add(ride);
        } else {
            throw new IllegalArgumentException("Isn't first on a Week");
        }
    }

    private void addAnotherRide(Ride ride){
        Ride previous = rides.get(rides.size() - 1);
        if (previous.getDay() == ride.getDay() && previous.getRound() + 1 == ride.getRound()) {
            rides.add(ride);
        } else if (previous.getDay() < ride.getDay() && ride.getRound() == 1) {
            rides.add(ride);
        } else {
            throw new IllegalArgumentException("Incorrect ride");
        }
    }

    public int noWorkOnDay() {
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < rides.size(); j++) {
                if (i == rides.get(j).getDay()) {
                    break;
                }
                if (j == rides.size() -1) {
                    return i;
                }
            }
        }
        return -1;
    }

//vagy: boolean tömb, ami szerepel azt true-ra, ami false, azt visszaadni.
//while ciklussal elegánsabb (??)
    public int noWorkOnDaySecondRelease() {
        for (int i = 1; i < 8; i++) {
            int j = 0;
            while (j < rides.size() && i != rides.get(j).getDay()) {
                j++;
            }
            if (j == rides.size()) {
                return i;
            }
        }
        return -1;
    }

    public List<Ride> getRides() {
        return rides;
    }
}
