package isahasa.fleet;
import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> listOfShips = new ArrayList<>();
    private int waitingCargo;
    private int waitingPersons;

    public void addShip(Ship ship) {
        listOfShips.add(ship);
    }

    public void loadShip(int passangers, int cargoWeight) {
        for (int i = 0; i < listOfShips.size(); i++) {
            //System.out.println(listOfShips.get(i).getClass());
            if (cargoWeight > 0) {
                if (listOfShips.get(i) instanceof CanCarryGoods) {
                    CanCarryGoods c = (CanCarryGoods) listOfShips.get(i);
                    cargoWeight = c.loadCargo(cargoWeight);
                }
            }
            if (passangers > 0) {
                if (listOfShips.get(i) instanceof CanCarryPassengers) {
                    CanCarryPassengers p = (CanCarryPassengers) listOfShips.get(i);
                    passangers = p.loadPassenger(passangers);
                }
            }
        }
        waitingPersons = passangers;
        waitingCargo = cargoWeight;
    }

    public int getWaitingCargo(){
        return waitingCargo;
    }

    public int getWaitingPersons(){
        return waitingPersons;
    }
}