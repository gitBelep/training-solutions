package methodchain.robot;

public class NavigationPoint {
    private int distanceNp;
    private int degreeNp;

    public NavigationPoint(int distance, int degree){
        this.degreeNp = degree;
        this.distanceNp = distance;
    }

    public int getDistanceNp() {
        return distanceNp;
    }
    public int getDegreeNp() {
        return degreeNp;
    }
}
