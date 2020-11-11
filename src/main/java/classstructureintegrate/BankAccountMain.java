package classstructureintegrate;

public class BankAccountMain {
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount();
        account1.openAccount("Jannik","10073217-12000098-67341590",700);
        BankAccount account2 = new BankAccount();
        account2.openAccount("Jenzen","10073217-12000098-40000000",1000);

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println("+300= ");
        System.out.println("+1000= ");
        account1.deposit(300);
        account2.deposit(1000);
//        System.out.println(account1.getBalance());
//        System.out.println(account2.getBalance());

        System.out.println("-500= ");
        System.out.println("-500= ");
        account1.withdraw(500);
        account2.withdraw(500);
//        System.out.println(account1.getBalance());
//        System.out.println(account2.getBalance());

        System.out.println("1->2 500");
        account1.transfer(500,account2);
        account1.getInfo();
        account2.getInfo();

        System.out.println("2->1 1000");
        account2.transfer(1000,account1);
        account1.getInfo();
        account2.getInfo();
    }
}
