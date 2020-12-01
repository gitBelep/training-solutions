package methodchain.robot;
import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int distance;
    private int degree;
    private List<NavigationPoint> navigationList = new ArrayList<>();

    public Robot go(int meter){
        distance = distance + meter;
        return this;
    }
    
//360¤ = 0¤
    public Robot rotate(int angle){
        degree = (degree + angle) % 360;
        return this;
    }
    public Robot registerNavigationPoint(){
        navigationList.add(new NavigationPoint(distance, degree));
        return this;
    }

    public List<String> getNavigationList(){
        List<String> ss = new ArrayList<>();
        for (NavigationPoint n : navigationList){
            ss.add("distance: " + n.getDistanceNp() + " azimut: " + n.getDegreeNp());
        }
        return ss;
    }

    public int getDistance() {
        return distance;
    }
    public int getAzimut() {
        return degree;
    }
}
