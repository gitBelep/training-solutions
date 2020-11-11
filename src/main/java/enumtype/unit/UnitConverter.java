package enumtype.unit;

import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

    public double convert(double length, LengthUnit source, LengthUnit target){
        double res1 = (length * source.inMm) / target.inMm;
        int res2 = (int) (res1 * 10000);
        double result = res2 / 10000.0;
        return result;
    }

    public List<LengthUnit> siUnits(){
        List<LengthUnit> siUnitList = new ArrayList<>();
        for (LengthUnit ll : LengthUnit.values())
        if (ll.si){
            siUnitList.add(ll);
        }
        return siUnitList;
    }
}
