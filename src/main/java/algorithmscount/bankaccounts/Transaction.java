package algorithmscount.bankaccounts;

public class Transaction {
    private String accountNumber;
    private TransactionType tt;
    private int amount;

    public Transaction(String accountNumber, TransactionType tt, int amount){
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.tt = tt;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public int getAmount() {
        return amount;
    }

    public boolean isCredit() {
        return (tt.name().equals("CREDIT"));
    }
    public boolean isDebit() {
        return (!tt.name().equals("CREDIT"));
    }
}
