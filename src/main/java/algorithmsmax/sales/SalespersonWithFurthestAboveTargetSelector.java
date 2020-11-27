package algorithmsmax.sales;
import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {
    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> splist){
        Salesperson[] personMaxAboveTarget = new Salesperson[1];
        personMaxAboveTarget[0] = splist.get(0);
        for (int i=1; i< splist.size(); i++) {
            if (splist.get(i).getDifferenceFromTarget() > personMaxAboveTarget[0].getDifferenceFromTarget()){
                personMaxAboveTarget[0] = splist.get(i);
            }
        }
        return personMaxAboveTarget[0];
    }
}
