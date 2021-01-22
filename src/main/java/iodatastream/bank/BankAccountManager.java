package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount account, Path path){
        Path file = path.resolve(account.getAccountNumber().concat(".dat"));
        try (DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))){
            ds.writeUTF(account.getAccountNumber());
            ds.writeUTF(account.getOwner());
            ds.writeDouble(account.getBalance());
        } catch (IOException e) {
            throw  new IllegalStateException("Cannot write file", e);
        }
    }

    public BankAccount loadAccount(InputStream ins){
        try(DataInputStream di = new DataInputStream(new BufferedInputStream(ins))){
            String accountNr = di.readUTF();
            String accountName = di.readUTF();
            double accountBalance = di.readDouble();
            return new BankAccount(accountNr, accountName, accountBalance);
        } catch (IOException e){
            throw new IllegalStateException("Cannot read file", e);
        }
    }

}
