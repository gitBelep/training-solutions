package exceptionclass.bank;

public class Account {
    private double balance;
    private double maxSubtract;
    private final String accountNumber;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null){
            throw new IllegalArgumentException("Account number cannot be null");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        maxSubtract = 100000d;
    }

    public double subtract(double subtract) {
        if (subtract > balance){
            throw new InvalidBankOperationException(ErrorCode.LOW_BALANCE);
        }
        if (subtract < 0){
            throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        }
        balance = subtract <= maxSubtract ? balance-subtract : balance-maxSubtract;
        return balance;
    }

    public double deposit (double deposit) {
        if (deposit < 0){
            throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        }
        balance += deposit;
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract < 0){
            throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        }
        this.maxSubtract = maxSubtract;
    }
}
