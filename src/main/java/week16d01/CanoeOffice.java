package week16d01;

import java.time.LocalDateTime;
import java.util.*;

public class CanoeOffice {
    private List<CanoeRental> rentals = new ArrayList<>();

    public void createRental(CanoeRental cr){
        rentals.add(cr);
    }

    public CanoeRental findRentalByName(String name){
        for (CanoeRental c : rentals){
            if (c.isActive() && c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public boolean closeRentalByName(String name, LocalDateTime endTime){
        for (CanoeRental c : rentals){
            if (c.isActive() && c.getName().equals(name)){
                c.setEndTime(endTime);
                System.out.println("új end: "+ c.getEndTime());
                return true;
            }
        }
        return false;
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime){
        for (CanoeRental c : rentals){
            if (c.isActive() && c.getName().equals(name)){
                return c.calculateRentalSum();
            }
        }
        return 0.0;
    }

    public List<CanoeRental> listClosedRentals(){
        List<CanoeRental> closed = new ArrayList<>();
        for (CanoeRental c : rentals){
            if (!c.isActive()){
                closed.add(c);
            }
        }
        closed.sort(Comparator.comparing(CanoeRental::getStartTime));
        return closed;
    }

    public Map<CanoeType, Integer> countRentals(){
        Map<CanoeType, Integer> byColour = new HashMap<>();
        for (CanoeRental c : rentals){
            if (!byColour.keySet().contains(c.getCanoeType())){
                byColour.put(c.getCanoeType(), 1);
            } else{
                byColour.put(c.getCanoeType(), byColour.get(c.getCanoeType()) +1);
            }
        }
        return byColour;
    }
}
