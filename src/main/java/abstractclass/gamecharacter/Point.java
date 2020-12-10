package abstractclass.gamecharacter;

public class Point {
    private final long x;
    private final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long distance(Point otherPt){
        return (long) Math.pow( (x - otherPt.getX())*(x-otherPt.getX()) + (y - otherPt.getY())*(y-otherPt.getY()), 0.5);
    }

    public long getX() {
        return x;
    }
    public long getY() {
        return y;
    }
}
