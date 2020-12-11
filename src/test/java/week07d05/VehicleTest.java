package week07d05;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    @Test
    public void motorTest() {
        Motorcycle m2 = new Motorcycle(4);
        assertEquals(4, m2.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, m2.getTransmissionType());

        Motorcycle mAlap = new Motorcycle();
        assertEquals(5, mAlap.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, mAlap.getTransmissionType());
    }

    @Test
    public void carTest() {
        Car c = new Car(7, TransmissionType.SEQUENTIAL);
        assertEquals(7, c.getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, c.getTransmissionType());

        Car cAlap = new Car();
        assertEquals(5, cAlap.getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, cAlap.getTransmissionType());
    }

    @Test
    public void truckTest() {
        Truck t = new Truck(11, TransmissionType.MANUAL);
        assertEquals(11, t.getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, t.getTransmissionType());

        Truck tAlap = new Truck();
        assertEquals(5, tAlap.getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, tAlap.getTransmissionType());
    }
}
