package week14d04;

import java.util.ArrayList;
import java.util.List;

public class Contract {
    private String client;
    private List<Integer> monthlyPrices;

    public Contract(String client, List<Integer> monthlyPrices) {
        this.client = client;
        this.monthlyPrices = monthlyPrices;
    }

//Másik megoldás
    public Contract(Contract contract, String rightClient) {
        this.client = rightClient;
        this.monthlyPrices = new ArrayList<>(contract.monthlyPrices);
    }

    public void setMonthlyPrices(List<Integer> monthlyPrices) {
        this.monthlyPrices = monthlyPrices;
    }

    public String getClient() {
        return client;
    }
    public List<Integer> getMonthlyPrices() {
        return monthlyPrices;
    }

    @Override
    public String toString() {
        return client + " " + monthlyPrices;
    }
}
