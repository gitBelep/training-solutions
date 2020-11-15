package controladvanced.cars;
import java.util.ArrayList;
import java.util.List;

public class UsedCars {

    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line: lines) {
            String[] parts = line.split(";");
            if(parts.length != 4) {
                continue;
            }
            if (parts[0].length() != 7){
                continue;
            }
            if (!parts[0].contains("-")){
                continue;
            }
            if (1970 > Integer.parseInt(parts[1]) || Integer.parseInt(parts[1]) > 2019){
                continue;
            }
            if (parts[3].equals("") || parts[2].equals("") ){
                continue;
            }
            validLines.add(line);
        }
        return validLines;
    }
}
