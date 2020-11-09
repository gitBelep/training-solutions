package finalmodifier;

public class PiMain {
    public static void main(String[] args) {

        CylinderCalculator cyCalc = new CylinderCalculator();

        System.out.println("Henger térfogata= " + cyCalc.calculateVolume(6.0, 2.25));

        System.out.println("Henger felülete= " + cyCalc.calculateSurfaceArea(6.0, 2.25));

        System.out.println("PI értéke: " + CircleCalculator.PI);
    }
}
