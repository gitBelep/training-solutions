package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airport {
    private List<Flight> flights = new ArrayList<>();

    public void readFile(Path source){
        try (BufferedReader br = Files.newBufferedReader(source)){
            String line;
            while ((line = br.readLine()) != null){
                fillListWihtPlanes(line);
            }
        } catch (IOException e){
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private void fillListWihtPlanes(String temp){
        String[] arr = temp.split(" ");
        String[] time = arr[3].split(":");
        int timeH = Integer.parseInt(time[0]);
        int timeMin = Integer.parseInt(time[1]);
        flights.add(new Flight(arr[0], FlightType.valueOf(arr[1].toUpperCase()), arr[2], LocalTime.of(timeH, timeMin)));
    }

    public FlightType whatsMore(){
        int counterArrival = 0;
        int counterDeparture = 0;
        for (Flight f : flights){
            if (f.getFlightType() == FlightType.ARRIVAL){
                counterArrival ++;
            } else {
                counterDeparture++;
            }
        }
        return counterArrival < counterDeparture ? FlightType.DEPARTURE : FlightType.ARRIVAL;
    }

    public Flight getFlightByNumber(String number){
        for (Flight f : flights){
            if (f.getFlightNumer().equals(number)){
                return f;
            }
        }
//      return null;
//      return new Flight("Nincs ilyen szám", FlightType.DEPARTURE, "",LocalTime.of(0,0));
        throw new IllegalArgumentException("No such Flightnumber");
    }

    public List<Flight> findFlights(String city, FlightType ft){
        List<Flight> report = new ArrayList<>();
        for (Flight f : flights){
            if (f.getCity().equals(city) && f.getFlightType() == ft){
                report.add(f);
            }
        }
        return report;
    }

//kétfajta elemből keresem az egyik minimumát!
    public Flight getEarliestDepartureFligt(){
        Flight earliestFlight = flights.get(0);
        LocalTime time = LocalTime.of(23,59);
        for (Flight f : flights){
            if (f.getTime().isBefore(time) && f.getFlightType() == FlightType.DEPARTURE){
               time = f.getTime();
               earliestFlight = f;
            }
        }
        return earliestFlight;
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }
}
