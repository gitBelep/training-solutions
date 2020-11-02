package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance tav = new Distance();
        System.out.println("Távolság: " + tav.getDistance() + ", pontosság: " +tav.isExact());
        int intPart = (int) tav.getDistance();
        System.out.println("Egész része: " + intPart);
    }
}
