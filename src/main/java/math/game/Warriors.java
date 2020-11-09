package math.game;
import java.util.Random;
public class Warriors {
    private String name;
    private int life;
    private Points position;
    private double ability;
    private final Random rnd = new Random();

    public Warriors (String name, Points position){
        this.name = name;
        this.position = position;
        life = rnd.nextInt(81) + 20;
        ability = rnd.nextDouble();
    }

    public void move(Points other){
        if (position.getX() > other.getX()) {
            position.setX(position.getX()-1);
        }
        if (position.getX() < other.getX()) {
            position.setX(position.getX()+1);
        }
        if (position.getY() > other.getY()) {
            position.setY(position.getY()-1);
        }
        if (position.getY() < other.getY()) {
            position.setY(position.getY()+1);
        }
    }
    public int distance(Warriors ww){
        return new Points(getPosition().getX(), getPosition().getY()).distance(ww);

    }
    public void attack(Warriors other){
        double rnd2 = rnd.nextDouble();
        if (rnd2 < other.getAbility()){
            int rnd3 = rnd.nextInt(2)  +1;
            other.setLife(other.getLife()-rnd3);
        }
    }
    public boolean isAlive(){
        return getLife()>0;
    }
     @Override
     public String toString(){
        return getName() +": ("+ getPosition().getX() +", "+ getPosition().getY()  +") "+ getLife();
     }

    public String getName() {
        return name;
    }
    public int getLife() {
        return life;
    }
    public Points getPosition() {
        return position;
    }
    public double getAbility() {
        return ability;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public void setPosition(Points position) {
        this.position = position;
    }
    public void setAbility(double ability) {
        this.ability = ability;
    }
}
