package methodpass.troopers;
import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    private List<Trooper> troopers = new ArrayList<>();

    public void addTrooper(Trooper trooper){
        if (trooper == null){
            throw new IllegalArgumentException("Trooper does not exist.");
        }
        troopers.add(trooper);
    }

    public List<Trooper> getTroopers(){
        return new ArrayList<>(troopers);
    }

    public void moveTrooperByName(String name, Position target){
        moveTrooper(findTrooperByName(name), target);
    }

    public void moveClosestTrooper(Position target){
        moveTrooper(findClosestTrooper(target), target);
    }

    private Trooper findTrooperByName(String name){
        if (name == null || "".equals(name.trim())){
            throw new IllegalArgumentException("Name must not be empty.");
        }
        for (int i = 0; i < troopers.size(); i++){
            if (troopers.get(i).getName().equals(name) ){
                return troopers.get(i);
            }
        }
        throw new IllegalArgumentException("No such trooper name exist.");
    }

    private Trooper findClosestTrooper(Position target){
        if (target == null ){
            throw new IllegalArgumentException("Target does not exist.");
        }
        double minDistance = Double.MAX_VALUE;
        double actuelDistance;
        int nearest =0;
        for (int i = 0; i < troopers.size(); i++){
            actuelDistance = troopers.get(i).getPosition().distanceFrom(target);
            if ( actuelDistance < minDistance){
                minDistance = actuelDistance;
                nearest = i;
            }
        }
        return troopers.get(nearest);
    }

    private Trooper moveTrooper(Trooper trooper, Position target){
        trooper.changePosition(target);
        return trooper;
    }

}
