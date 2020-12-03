package methodpass.troopers;

public class Position {
    private final double posX;
    private final double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double distanceFrom(Position otherPos){
        double xx = Math.pow( (getPosX() - otherPos.getPosX()), 2.0 );
        double yy = Math.pow( (getPosY() - otherPos.getPosY()), 2.0 );
        return Math.pow( (xx + yy), 0.5);
    }

    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }
}
