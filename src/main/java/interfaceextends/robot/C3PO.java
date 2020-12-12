package interfaceextends.robot;
import java.util.ArrayList;
import java.util.List;

public class C3PO implements MoveableRobot{
    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();

    public C3PO(Point position) {
        this.position = position;
    }

    @Override
    public void moveTo(Point position){
        path.add(position);
        this.position = position;
    }

    @Override
    public void fastMoveTo(Point position){
        moveTo(position);
    }

    @Override
    public void rotate(int angle){
        this.angle += angle;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }

    public int getAngle(){
        return angle;
    }
    public Point getPosition() {
        return position;
    }
}
