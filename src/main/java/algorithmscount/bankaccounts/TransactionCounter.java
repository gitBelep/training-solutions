package algorithmscount.bankaccounts;
import java.util.List;

public class TransactionCounter {
    public int countEntryLessThan(List<Transaction> transactions, int amount){
        int counter =0;
        for (Transaction t : transactions){
            if (t.isCredit() && t.getAmount() < amount){
                counter++;
            }
        }
    return counter;
    }
}
