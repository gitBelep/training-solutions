package week12d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NumberStat {
    private List<Integer> numbers = new ArrayList<>();

    public void fillList(String pathStr) {
        Path file = Path.of(pathStr);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                numbers.add(Integer.parseInt(strings[0]));
                numbers.add(Integer.parseInt(strings[1]));
                numbers.add(Integer.parseInt(strings[2]));
            }
        } catch (IOException | NumberFormatException ex) {
            throw new IllegalStateException("Cannot read file", ex);
        }
    }

    public int findTheSmallestUnique(List<Integer> numbers) {
        return chooseTheUnique(numbers);
    }

    public int findTheSmallestUnique() {
        return chooseTheUnique(numbers);
    }

    private int chooseTheUnique(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List must have at least one element");
        }
        numbers.sort(null);
        for (int i = 1; i < numbers.size() - 1; i++) {
            int previous = numbers.get(i - 1);
            int actual = numbers.get(i);
            int next = numbers.get(i + 1);
            if (previous < actual && actual < next) {
                return numbers.get(i);
            }
        }
        throw new IllegalArgumentException("There is no smallest unique elemet");
    }

}