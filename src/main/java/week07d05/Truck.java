package week07d05;

public class Truck extends Car{
    private int numberOfGears;
    private TransmissionType transmissionType;

    public Truck(int numberOfGears, TransmissionType transmissionType) {
        this.numberOfGears = numberOfGears;
        this.transmissionType = transmissionType;
    }

    public Truck() {
        numberOfGears = super.getNumberOfGears();
        transmissionType = super.getTransmissionType();
    }

    @Override
    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public TransmissionType getTransmissionType() {
        return transmissionType;
    }
}
