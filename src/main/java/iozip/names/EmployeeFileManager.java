package iozip.names;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {

    public void saveEmployees(Path zipFile, List<String> employees){
        try (ZipOutputStream zo = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(zipFile)))) {
                   zo.putNextEntry(new ZipEntry("names.dat"));
                   for (String s : employees){
                       zo.write(s.getBytes());
                   }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }
}
