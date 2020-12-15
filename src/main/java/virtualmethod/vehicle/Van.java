package virtualmethod.vehicle;

public class Van extends Car{
    private int cargoWeight;

    public Van(int numberOfPassangers, int vehicleWeight, int cargoWeight){
        super(vehicleWeight, numberOfPassangers);
        this.cargoWeight = cargoWeight;
    }

    @Override
    public int getGrossLoad(){
        return super.getGrossLoad() + cargoWeight;
    }

//Van{cargoWeight=1222, numberOfPassenger=4, vehicleWeight=1200}
public String toString() {
    return "Van{cargoWeight="+ cargoWeight + ", numberOfPassenger="+ super.getNumberPassenger() +
            ", vehicleWeight="+ super.getVehicleWeight() +'}';
}
}
