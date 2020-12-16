package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods {
    private final int maxCargoWeight;
    private int cargoWeight;

    public CanCarryGoodsBehaviour(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

//    paramétere a betöldendő rakomány súlya,
//    visszatér a le nem tárolt rakomány súlyával.
    @Override
    public int loadCargo(int weight) {
        if (weight >= maxCargoWeight) {
            this.cargoWeight = maxCargoWeight;
            return weight - maxCargoWeight;
        }
        this.cargoWeight = weight;
        return 0;

    }

    @Override
    public int getCargoWeight(){
        return cargoWeight;
    }
}
