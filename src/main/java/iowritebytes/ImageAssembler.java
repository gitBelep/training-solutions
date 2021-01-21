package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] bytes, Path path){
     //   Path file = Path.of(path.toString() + "/image.png");  //hozzáfűzni a filenevet!
        Path file = path.resolve("image.png");
        try (BufferedOutputStream bo = new BufferedOutputStream(Files.newOutputStream(file))){
            for (byte[] b : bytes){
                bo.write(b);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file");
        }
    }

}
