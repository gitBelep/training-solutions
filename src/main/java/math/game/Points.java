package math.game;

public class Points {
    private int x;
    private int y;

    public Points(int x, int y){
        this.x = x;
        this.y =y;
    }

    public int distance(Warriors ww) {
        double xx = (double) getX() - ww.getPosition().getX();
        double yy = (double) getY() - ww.getPosition().getY();
        return (int) Math.sqrt(xx*xx + yy*yy);
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
