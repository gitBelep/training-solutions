package week13d02;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    @Test
    void readFile() {
        Airport a = new Airport();
        a.readFile(Path.of("src/main/resources/TimeTable.txt"));
        assertEquals(100, a.getFlights().size());

//        List<Flight> temp = a.getFlights();
//        int line = 1;
//        for (Flight f : temp){
//            System.out.println(line++ + f.getFlightNumer());
//        }
    }

    @Test
    void whatsMore() {
        Airport a = new Airport();
        a.readFile(Path.of("src/main/resources/TimeTable.txt"));

        assertEquals(FlightType.DEPARTURE, a.whatsMore());
    }

    @Test
    void getFlightByNumber() {
        Airport a = new Airport();
        a.readFile(Path.of("src/main/resources/TimeTable.txt"));

        assertEquals("Budapest", a.getFlightByNumber("SW1667").getCity());
        //100.
        assertEquals(LocalTime.of(9,35), a.getFlightByNumber("MN5047").getTime());
    }

    @Test
    void findFlights() {
        Airport a = new Airport();
        a.readFile(Path.of("src/main/resources/TimeTable.txt"));

        assertEquals(3, a.findFlights("Budapest", FlightType.ARRIVAL).size());
        assertEquals(2, a.findFlights("Moscow", FlightType.DEPARTURE).size());

    }

    @Test
    void getEarliestFligt() {
        Airport a = new Airport();
        a.readFile(Path.of("src/main/resources/TimeTable.txt"));

        assertEquals("FG3210 DEPARTURE Zurich 06:16", a.getEarliestDepartureFligt().toString());
    }
}