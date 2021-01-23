package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {

    public void saveTransactions(Path path, List<Transaction> transactions){
        try (ZipOutputStream zo = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))){
            for (Transaction t : transactions) {
                zo.putNextEntry(new ZipEntry( Long.toString(t.getId()) ));
                String toWrite = t.getTime().toString() +"\n"+ t.getAccount() +"\n"+ t.getAmount() +"\n";
                zo.write(toWrite.getBytes());
                zo.closeEntry();
//gondolom kell, mert nem a for-ban van a try with R.
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

}