package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {

    public void writeTemperatures(Temperatures temperatures, String pathString){
        try {
            Path filePath = Path.of(pathString);
            Files.write(filePath, temperatures.getData());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
