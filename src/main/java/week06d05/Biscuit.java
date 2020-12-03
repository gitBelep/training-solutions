package week06d05;

public class Biscuit {
    BiscuitType type;
    int gramAmount;

    public Biscuit(BiscuitType type, int gramAmount) {
        checkAmount(gramAmount);
        this.gramAmount = gramAmount;
        this.type = type;
    }

    public static Biscuit of(BiscuitType biscuitType, int gramAmount){
        checkAmount(gramAmount);
        return new Biscuit(biscuitType,gramAmount);
    }

    private static void checkAmount(int gramAmount){
        if (gramAmount < 1 || gramAmount > 25_000){
            throw new IllegalArgumentException("It is not a retail pack.");
        }
    }

    @Override
    public String toString() {
        return "Biscuit{" +
                "type=" + type +
                ", gramAmount=" + gramAmount +
                '}';
    }
}
