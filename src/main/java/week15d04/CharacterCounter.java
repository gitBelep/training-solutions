package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CharacterCounter {
    int charCounter = 0;
    int wowelCounter = 0;
    int letterCounter = 0;

    public List<Integer> countingEnglishCharacters(String pathStr) {
        Path path = Path.of("src", "main", "resources").resolve(pathStr);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                numberOfWowelsConsonantsAndSum(line);
            }
            return giveResult();
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void numberOfWowelsConsonantsAndSum(String line) {
        List<Character> wowels = new ArrayList<>(List.of('a','e','i','o','u','A','E','I','O','U'));
        for (char c : line.toCharArray()) {
            if (c != 32) {
                charCounter ++;
            }
            if (65 <= c && c <= 90 || 97 <= c && c <= 122) {
                if (wowels.contains(c)) {
                    wowelCounter++;
                }
                letterCounter++;
            }
        }
    }

    private List<Integer> giveResult() {
        List<Integer> result = new ArrayList<>(List.of(0,0,0));
        result.set(0, result.get(0) + charCounter);
        result.set(1, result.get(1) + wowelCounter);
        result.set(2, result.get(2) + letterCounter - wowelCounter);
        return result;
    }

}
