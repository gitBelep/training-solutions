package classsctructureintegrate;
public class BankAccount {

    private String accountNumber;
    private String owner;
    private int balance = 0;

    public void getInfo() {
        System.out.println(owner +" ("+accountNumber+"): "+balance +" Ft");
    }

    public void openAccount(String owner, String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int plus){
        balance = balance + plus;
    }

    public void withdraw(int minus){
        balance = balance-minus;
    }

    public void transfer(int trAmount, BankAccount target){
        this.balance = balance-trAmount;
        target.deposit(trAmount);
    }
}
