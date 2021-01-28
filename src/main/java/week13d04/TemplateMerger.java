package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

//egybeolvaszt
public class TemplateMerger {
    public String merge(Path file, List<Employee> employees){

        try {
            String line = Files.readString(file);
            StringBuilder sb = new StringBuilder();
            for (Employee e : employees) {
                String replaced = line.replace("{név}", e.getName());
                replaced = replaced.replace("{év}", Integer.toString(e.getYearOfBirth()));
                sb.append(replaced).append("\n");
            }
            return sb.toString();
        } catch (IOException e){
            throw new IllegalArgumentException("Cannot read file",e);
        }
    }

}
