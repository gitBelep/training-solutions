package week14d04;

import java.util.ArrayList;
import java.util.List;

public class ContractCreator {
    private Contract template;

    public ContractCreator(String musterName, List<Integer> monthlyPrices) {
        template = new Contract(musterName, monthlyPrices);
    }

//Egyik megoldás - önmagában
    public Contract create(String client){
        return new Contract(client, new ArrayList<>(template.getMonthlyPrices()));
    }

//Másik megoldás - copy konstruktorral a Contractban
    public Contract create2(String rightClient){
        return new Contract(template, rightClient);
    }

}
