package methodpass.troopers;

public class Trooper {
    private String name;
    private Position position = new Position(0d,0d);

    public Trooper(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
    }

    public double distanceFrom(Position targetPos){
        return position.distanceFrom(targetPos);
    }

    public void changePosition(Position targetPos){
        if (targetPos == null){
            throw new IllegalArgumentException("Give me the new Position!");
        }
        position = new Position(targetPos.getPosX(), targetPos.getPosY());
    }

    public String getName() {
        return name;
    }
    public Position getPosition() {
        return position;
    }

}
