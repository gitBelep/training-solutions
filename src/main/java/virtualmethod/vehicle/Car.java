package virtualmethod.vehicle;

public class Car extends Vehicle{
    private int numberPassenger;

    public Car(int vehicleWeight, int numberPassenger) {
        super(vehicleWeight);
        this.numberPassenger = numberPassenger;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + numberPassenger * PERSON_AVERAGE_WEIGHT;
    }

    @Override  //Car{numberOfPassenger=4, vehicleWeight=1700}
    public String toString() {
        return "Car{numberOfPassenger="+ numberPassenger +", vehicleWeight="+
                super.getVehicleWeight() +'}';
    }

    public int getNumberPassenger() {
        return numberPassenger;
    }
}
