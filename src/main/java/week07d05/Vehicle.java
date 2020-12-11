package week07d05;

public abstract class Vehicle {

    public int getNumberOfGears() {
        return 5;
    }

    public TransmissionType getTransmissionType() {
        return TransmissionType.MANUAL;
    }
}
