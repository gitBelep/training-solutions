package week07d05;

public class Motorcycle extends Vehicle{
    private int numberOfGears;

//motornak nem kell magadni TransmissionType-ot, az mindig .SEQUENTIAL
    public Motorcycle(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public Motorcycle() {
        numberOfGears = super.getNumberOfGears();
    }

    @Override
    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public TransmissionType getTransmissionType() {
        return TransmissionType.SEQUENTIAL;
    }
}
