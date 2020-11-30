package immutable.satellite;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {
    private List<Satellite> satellites = new ArrayList<>();

    private boolean isEmpty(Satellite sat) {
        if (sat == null ) {
            throw new NullPointerException("Parameter must not be null!");
        }
        return false;
    }

    public void registerSatellite(Satellite satellite){
        isEmpty(satellite);
        satellites.add(satellite);
    }

    @Override
    public String toString() {
        return satellites.toString();
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent){
        for (Satellite s:satellites){
            if (s.getId().equals(registerIdent)){
                return s;
            }
        }
        throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);
    }
}
