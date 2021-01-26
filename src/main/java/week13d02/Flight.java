package week13d02;

import java.time.LocalTime;

public class Flight {

    private String flightNumer;
    private FlightType flightType;
    private String city;
    private LocalTime time;

    public Flight(String flightNumer, FlightType flightType, String city, LocalTime time) {
        this.flightNumer = flightNumer;
        this.flightType = flightType;
        this.city = city;
        this.time = time;
    }

    public String getFlightNumer() {
        return flightNumer;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return flightNumer +" "+ flightType +" "+ city +" "+ time;
    }
}
