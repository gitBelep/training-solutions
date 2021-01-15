package iowriter.names;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {
    private final Path file;

    public NameWriter(Path file){
        this.file = file;
    }

    public void addAndWrite(String name){
        try (BufferedWriter br = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            br.write(name +"\n");
        } catch (IOException oie){
            throw new IllegalStateException("Cannor write file", oie);
        }
    }
}
