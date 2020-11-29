package algorithmsdecision.bankaccounts;
import java.util.List;

public class TransactionExecutor {

    //Credit ++, Debit --
    public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {
        for (Transaction t : transactions) {
            for (BankAccount b : accounts) {
                if (b.getAccountNumber().equals(t.getAccountNumber())) {
                    if (t.isCredit()) {
                        b.setBalance(b.getBalance() + t.getAmount());
                    } else {
                        if (b.getBalance() >= t.getAmount()) {
                            b.setBalance(b.getBalance() - t.getAmount());
                        }
                    }
                    break;
                }
            }
        }
    }
}
