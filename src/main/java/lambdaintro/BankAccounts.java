package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {
    private List<BankAccount> accounts;

    public BankAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> result = new ArrayList<>(accounts);
//ua  result.sort((BankAccount b1, BankAccount b2) -> b1.getAccountNumber().compareTo(b2.getAccountNumber()));
        result.sort(Comparator.comparing(BankAccount::getAccountNumber));
        return result;
    }

    public List<BankAccount> listBankAccountsByBalance(){
        List<BankAccount> result = new ArrayList<>(accounts);
        result.sort((BankAccount b1, BankAccount b2) ->  (int) (Math.abs(b1.getBalance()) - Math.abs(b2.getBalance()) ) );
        return result;
    }   //megoldásban:
// ordered.sort(Comparator.comparing((a) -> Math.abs(a.getBalance())));


    public List<BankAccount> listBankAccountsByBalanceDesc(){
        List<BankAccount> result = new ArrayList<>(accounts);
        result.sort(Comparator.comparingDouble(BankAccount::getBalance).reversed());
result.sort( (BankAccount b1, BankAccount b2) ->  (int) (b1.getBalance() - b2.getBalance()));
//result.sort(Comparator.reverseOrder());   //nem jó
return result;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber(){
        List<BankAccount> result = new ArrayList<>(accounts);
        Collator huC = Collator.getInstance(new Locale("hu", "HU"));
        result.sort(Comparator.comparing(BankAccount::getNameOfOwner, Comparator.nullsFirst(huC)).thenComparing(BankAccount::getAccountNumber));
        return result;
    }

}
