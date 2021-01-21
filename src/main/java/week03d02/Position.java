package week03d02;
import java.util.ArrayList;
import java.util.List;

public class Position {
    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }
    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString(){
        return this.getName() +" ~ "+ this.getBonus() +" Ft";
    }

    public static void main(String[] args) {
        Position p1 = new Position("Fönök", 7000_000);
        Position p2 = new Position("Művezető", 70_000);
        Position p3 = new Position("Kubikos", 7000);

        List<Position> pos = new ArrayList<>();
        pos.add(p1);
        pos.add(p2);
        pos.add(p3);

        for (Position i : pos){
            if (i.getBonus() > 150_000) {
                System.out.println(i);
            }
        }
        
    }
}
