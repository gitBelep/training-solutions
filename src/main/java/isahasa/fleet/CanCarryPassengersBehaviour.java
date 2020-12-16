package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers{
    private int passengers;
    private final int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        int remainingPassengers = 0;
        if (passengers >= maxPassengers){
            this.passengers = maxPassengers;
            remainingPassengers = passengers - maxPassengers;
        } else {
            this.passengers = passengers;
        }
        return remainingPassengers;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }
}
