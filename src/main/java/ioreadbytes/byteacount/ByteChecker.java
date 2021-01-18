package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String file) {
        Path path = Path.of(file);
        try (InputStream ins = new BufferedInputStream(Files.newInputStream(path)) ) {
            byte[] buffer = new byte[100];
            int size = 0;
            int turn = 0;
            int rest = 0;
            while ( (size = ins.read(buffer)) > 0 ){
                turn++;
                rest = size;
            }

            return (turn - 1) * 100 + rest;
        } catch(IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

}
