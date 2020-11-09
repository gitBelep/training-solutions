package finalmodifier;

public class CylinderCalculator {

    CircleCalculator cc = new CircleCalculator();

    public double calculateVolume(double r, double h){
        return r*r*cc.getPI()*h;
    }

    public double calculateSurfaceArea(double r, double h){
        return 2*r*r*cc.getPI()+2*r*cc.getPI()*h;
    }
}
