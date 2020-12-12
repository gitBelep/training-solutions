package interfaceextends.robot;
import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot{
    final static long ALTITUDE = 5;
    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();

    public AstroBoy(Point position) {
        this.position = position;
    }

    @Override
    public void moveTo(Point position) { // delegálja a funkciót
        walkTo(position);
    }
    public void walkTo(Point position){
        path.add(position);
        this.position = position;
    }

    @Override
    public void fastMoveTo(Point position) { //komplex mozgás, felemelkedik, elrepül a célpont fölé, és leereszkedik
        liftTo(ALTITUDE);
        flyTo(position);
    }

    @Override
    public void liftTo(long altitude){
        path.add(new Point(position.getX(),position.getY(), altitude));
        this.position = path.get(path.size()-1);
    }

    public void flyTo(Point position){
        path.add(new Point(position.getX(),position.getY(), path.get(path.size()-1).getZ()));
        path.add(position);
        this.position = position;
    }

    @Override
    public void rotate(int angle){
        this.angle += angle;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }

    public Point getPosition() {
        return position;
    }
    public int getAngle() {
        return angle;
    }
    public long getAltitude() {
        return position.getZ();
    }
}
