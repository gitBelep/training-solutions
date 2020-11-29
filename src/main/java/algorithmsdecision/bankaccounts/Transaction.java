package algorithmsdecision.bankaccounts;
import java.time.LocalDateTime;

public class Transaction {
    private String accountNumber;
    private TransactionOperation transactionOperation;
    private int amount;
    private LocalDateTime dateOfTransaction;
    private TransactionStatus tStatus;

    public Transaction(String accountNumber, TransactionOperation transactionOperation, int amount, LocalDateTime dateOfTransaction) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.dateOfTransaction = dateOfTransaction;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public boolean isCredit() { return (transactionOperation.name().equals("CREDIT")); }
    public boolean isDebit() { return (!transactionOperation.name().equals("CREDIT")); }
    public int getAmount() {
        return amount;
    }
    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }
    public TransactionStatus getTransactionStatus() {
        return tStatus;
    }
}
