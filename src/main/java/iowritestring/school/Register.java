package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {

    public void newMark(Path path, int mark) {
        try {
            if (!Files.exists(path)) {      //itt nem számít, hozzáfűzök-e sortörést
                Files.writeString(path, Integer.toString(mark)+"\n");
            } else {
                Files.writeString(path, mark +"\n", StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void average(Path file) {
        try {
            int sum = 0;
            List<String> markList = Files.readAllLines(file);
            for (String s : markList){
                sum += Integer.parseInt(s);
            }
            double average = (double) sum / markList.size();
            Files.writeString(file, "average: "+ average, StandardOpenOption.APPEND);

        } catch (IOException | NumberFormatException ex) {
            throw new IllegalStateException("File elérés hiba", ex);
        }
    }

}
