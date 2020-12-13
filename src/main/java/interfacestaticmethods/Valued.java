package interfacestaticmethods;
import java.util.List;

public interface Valued {

//a tesztből levezetett method
    static double totalValue(List<Valued> list){
        return sum(list);
    }

//a megkövetelt sum()
    static private double sum(List<Valued> list){
        double result = 0.0;
        for (Valued v : list) {
            result += v.getValue();
        }
        return result;
    }

//az egyetlen abstract
    public double getValue();
}

/*    Készíts egy Valued interfészt, mely egyetlen absztrakt metódust definiál.
*    A getValue() metódus egy Valued példány értékét adja meg. Hozz létre az
*    interfészben egy sum() metódust, mely paraméterként egy List<Valued>
*    típusú adatot kap, és a benne található elemek összértékét számítja ki!
*/