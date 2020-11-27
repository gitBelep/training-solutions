package algorithmsmax.sales;
import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {
    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> splist){
        Salesperson[] personMaxBelowTarget = new Salesperson[1];
        personMaxBelowTarget[0] = splist.get(0);
        for (int i=1; i< splist.size(); i++) {
            if (splist.get(i).getDifferenceFromTarget() < personMaxBelowTarget[0].getDifferenceFromTarget()){
                personMaxBelowTarget[0] = splist.get(i);
            }
        }
        return personMaxBelowTarget[0];
    }
}
