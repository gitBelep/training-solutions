package week07d05;

public class Car extends Vehicle{
    private int numberOfGears;
    private TransmissionType transmissionType;

//Konstruktorok: vagy megadod mind2 attributumot, vagy mind2 öröklött.

    public Car(int NumberOfGears, TransmissionType tt) {
        this.numberOfGears = NumberOfGears;
        transmissionType = tt;
    }

    public Car() {
        this.numberOfGears = super.getNumberOfGears();
        this.transmissionType = TransmissionType.AUTOMATIC;
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
