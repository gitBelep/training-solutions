package algorithmsmax.sales;
import java.util.List;

public class SalesAmountMaxSelector {
    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> splist){
        Salesperson[] personMaxAmount = new Salesperson[1];
        personMaxAmount[0] = splist.get(0);
        for (int i=1; i< splist.size(); i++) {
            if (splist.get(i).getAmount() > personMaxAmount[0].getAmount()){
                personMaxAmount[0] = splist.get(i);
            }
        }
        return personMaxAmount[0];
    }
}
