package abstractclass.gamecharacter;
import java.util.Random;

public abstract class Character {
    private Point position;
    private int hitPoint;
    private Random rnd;

    public Character(Point position, Random rnd) {
        this.position = position;
        hitPoint = 100;
        this.rnd = rnd;
    }

    public boolean isAlive(){
        return hitPoint > 0;
    }

    protected int getActualPrimaryDamage(){
        return rnd.nextInt(10)+1;
    }

    public void primaryAttack(Character enemy){
        hit(enemy,getActualPrimaryDamage());
    }

    protected void hit(Character enemy, int damage){
        if (enemy.getActualDefence() < damage){
            enemy.decreaseHitPoint(damage);
        }
    }
    private int getActualDefence(){
        return rnd.nextInt(5)+1;
    }
    private void decreaseHitPoint(int diff) {
        hitPoint -= diff;
    }
    public Point getPosition() {
        return position;
    }
    public int getHitPoint() {
        return hitPoint;
    }
    public Random getRnd() {
        return rnd;
    }

    abstract public void secondaryAttack(Character enemy);
}
