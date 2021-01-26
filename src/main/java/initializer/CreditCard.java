package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    public static List<Rate> ACTUAL_RATES = new ArrayList<>();
    private long balance;

    public CreditCard(long balance, Currency currency, List<Rate> r) {
        ACTUAL_RATES.addAll(r);
        this.balance = Math.round(balance * getActualRate(currency));
    }

    public CreditCard(long balance, Currency currency) {
        this.balance = Math.round(balance * getActualRate(currency));
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    private double getActualRate(Currency currency) {
        for (Rate r : ACTUAL_RATES) {
            if (r.getCurrency() == currency) {
                return r.getConversionFactor();
            }
        }
        return 1;  //HUF..
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency){
        if ( balance >= amount * getActualRate(currency) ) {
            balance -= amount * getActualRate(currency);
            return true;
        }
        return false;
    }

    public boolean payment(long amount){
        return payment(amount, Currency.HUF);     //áthív
    }

}
