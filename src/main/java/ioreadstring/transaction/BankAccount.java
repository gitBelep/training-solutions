package ioreadstring.transaction;

public class BankAccount {
    private final String name;
    private final String accountNumber;
    private double balance;

    public BankAccount(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount){
        if (balance * -1  <= amount) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Not enough balance");
        }
    }
}
