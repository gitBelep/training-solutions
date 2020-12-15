package virtualmethod.vehicle;

public class FerryBoat extends Vehicle{
    private int vehicleWeight;
    private static int MAX_CARRY_WEIGHT =2000;
    private Car car = null;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }

    @Override
    public int getGrossLoad(){
        return super.getGrossLoad() + car.getGrossLoad();
    }

    public boolean load(Car car){
        if (car.getGrossLoad() <= MAX_CARRY_WEIGHT){
            this.car = car;
            return true;
        }
        return false;
    }

    public boolean canCarry(Car car){
        return car.getGrossLoad() <= MAX_CARRY_WEIGHT;
    }

//FerryBoat= + a tárolt autó toString eredménye:
//•	FerryBoat{car=Van{cargoWeight=200, numberOfPassenger=1, vehicleWeight=1200}}
//•	FerryBoat{car=Car{numberOfPassenger=1, vehicleWeight=1200}}
    @Override
    public String toString() {
        return "FerryBoat{car=" + car.toString() + '}';
    }
}
