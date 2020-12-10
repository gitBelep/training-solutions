package interfaces.animal;

public class Lion implements Animal{
    private int numberOfLegs;
    private String name;

    public Lion() {
        this.numberOfLegs = 4;
        this.name = "Lion";
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String getName() {
        return name;
    }
}
