package week15d01;

import java.util.Map;
import java.util.TreeMap;

public class FindMax {

    public Map.Entry<Double, Double> findLastXToMaxY(Map<Double, Double> data) {
        if (data == null || data.size() == 0) {
            throw new IllegalArgumentException("No data");
        }

        Map.Entry<Double, Double> result = null;
        double maxY = Double.MIN_VALUE;

        for (Map.Entry<Double, Double> e : data.entrySet())
            if (maxY <= e.getValue()) {
                maxY = e.getValue();
                result = e;
            }
        return result;
    }

//Így nem kell számláló, ám minden ciklusban nullt ellenőriz:
//        for (Map.Entry<Double, Double> e : data.entrySet()) {
//            if (result == null || result.getValue() <= e.getValue()) {
//                result = e;  } }

    public Map<Double, Double> findXValuesToMaxY(Map<Double, Double> data) {
        if (data == null || data.size() == 0) {
            throw new IllegalArgumentException("No data");
        }

        Map<Double, Double> result = new TreeMap<>();
        double maxY = Double.MIN_VALUE;

        for (Map.Entry<Double, Double> e : data.entrySet())
            if (maxY <= e.getValue()) {
                maxY = e.getValue();
                result.put(e.getKey(), e.getValue());
            }
        return result;
    }

}
//Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját megkapjuk
//egy Map-ben. A map kulcsa az x koordináta értéke pedig az y koordináta. Döntsük el,
//hogy a kapott pontok küzül, hol van a függvénynek maximum helye és ott mennyi az értéke
