package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<BankAccount> accountList = new ArrayList<>();

    public void uploadListFromFile(String path){
        try {
            List<String> listOfAccounts = Files.readAllLines( Path.of(path) );
            for (String s : listOfAccounts) {
                String[] oneAccount = s.split(";");
                double balance = Double.parseDouble(oneAccount[2]);
                accountList.add( new BankAccount(oneAccount[0], oneAccount[1], balance) );
            }
        } catch (IOException | NumberFormatException ex) {
            throw new IllegalArgumentException("problem by loading file", ex);
        }
    }

    public void makeTransactions(String path){
        try {
            List<String> listOfTransaktions = Files.readAllLines( Path.of(path) );
            for (String s : listOfTransaktions) {
                String[] oneTransaktion = s.split(";");
                double transaktionAmount = Double.parseDouble(oneTransaktion[1]);
                for (BankAccount ba : accountList){
                    if (ba.getAccountNumber().equals(oneTransaktion[0])){
                        ba.setBalance(transaktionAmount);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }
}
