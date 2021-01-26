package iofilestest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class CheeseManager {

    public void saveToFile(List<Cheese> cheeses, Path target){
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(target, CREATE)))) {
            for (Cheese c : cheeses){
                dos.writeUTF(c.getName());
                dos.writeDouble(c.getLactose());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public Cheese findCheese(String cheese, Path source){
        try (DataInputStream ds = new DataInputStream(new BufferedInputStream(Files.newInputStream(source)))){
            String actualName = "";
            while ( (actualName = ds.readUTF()) != null) {
                double actualLactose = ds.readDouble();
                if (cheese.equals(actualName)) {
                    return new Cheese(actualName, actualLactose);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        throw new IllegalStateException("No such Name");
    }
}
