package exam03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < boat.getMaxPassengers()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("Overbooked");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return basicPrice * passenger.getCruiseClass().extra;
    }

    public Passenger findPassengerByName(String name) {
        Passenger result = null;
        for (Passenger p : passengers) {
            if (p.getName().equals(name)) {
                result = p;
            }
        }
        return result;
    }

    public List<String> getPassengerNamesOrdered(){
        List<String> names = new ArrayList<>();
        for (Passenger p : passengers){
            names.add(p.getName());
        }
        names.sort(null);
        return names;
    }

    public double sumAllBookingsCharged(){
        double sum = 0;
        for (Passenger p : passengers){
            sum += getPriceForPassenger(p);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass(){
        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Passenger p : passengers){
            if (result.containsKey(p.getCruiseClass())){
                result.put(p.getCruiseClass(), result.get(p.getCruiseClass()) + 1);
            } else {
                result.put(p.getCruiseClass(), 1);
            }
        }
        return result;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }
}
