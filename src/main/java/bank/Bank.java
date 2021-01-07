package bank;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null){
            throw new IllegalArgumentException("Accounts cannot be null");
        }
        this.accounts = accounts;
    }

    public void payment(String accountNumber, double amount){
        boolean found = false;
        for (Account a : accounts){
            if (a.getAccountNumber().equals(accountNumber)){
                a.subtract(amount);
                found = true;
            }
        }
        if (!found){
            throw new InvalidBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
        }
    }

    public void deposit(String accountNumber, double amount){
        boolean found = false;
        for (Account a : accounts){
            if (a.getAccountNumber().equals(accountNumber)){
                a.deposit(amount);
                found = true;
            }
        }
        if (!found){
            throw new InvalidBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
        }
    }

}
