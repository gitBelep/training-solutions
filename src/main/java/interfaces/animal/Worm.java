package interfaces.animal;

public class Worm implements Animal {
    private int numberOfLegs = 0;
    private String name = "Worm";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
}
