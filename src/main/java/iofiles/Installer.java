package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {

    public void install(String pathStr){
        Path path = Path.of(pathStr);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }
        InputStream ins = Installer.class.getResourceAsStream("/install/install.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(ins))){
            String line;
            while ( (line = br.readLine()) != null){
                if(line.endsWith("/")){
                    Files.createDirectory( path.resolve(line) );
                } else {
//Source mert nem Filerendszer-beli file
                    InputStream source = Installer.class.getResourceAsStream("/install/"+ line );
                    Files.copy(source, path.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException ioe){
            throw new IllegalArgumentException("Copy problem", ioe);
        }
    }
}
