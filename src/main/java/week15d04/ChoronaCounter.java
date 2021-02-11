package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChoronaCounter {
    List<FallPerWeek> cases = new ArrayList<>();

    public List<String> choronaCases() {
        Path path = Path.of("src", "main", "resources", "w15d4_data.csv");
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            skipFirstLine(br);
            while ((line = br.readLine()) != null) {
                countingCases(line);
            }
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        cases.sort(Comparator.comparing(FallPerWeek::getNumber).reversed());
        List<String> result = new ArrayList<>();
        for (FallPerWeek f : cases.subList(0, 3)) {
            result.add(f.getWeek() + ": " + f.getNumber());
        }
        return result;
    }

    public void countingCases(String line) {
        String[] parts = line.split(",");
        if (parts[4].equals("Hungary")) {
            cases.add(new FallPerWeek(parts[1], Integer.parseInt(parts[2])));
        }
    }

    private void skipFirstLine(BufferedReader br) throws IOException{
        br.readLine();
    }
    
}

