package week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

//Ez a rész csak hibakezelés
    public Map<String, Integer> countWords(BufferedReader br, String... words) {
        try {
            return readingText(br, words);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private Map<String, Integer> readingText(BufferedReader br, String[] words) throws IOException{
        String line;
        Map<String, Integer> result = setupMap(words);      //if prewValue == null{}
        while ((line = br.readLine()) != null){
            for (String actual : words) {
                counting(line, actual, result);             //kiszervezve
            }
        }
        return result;
    }

//Nem kell visszatérnie semmivel, mert referencia típusú Map-en dolgozik
    private void counting(String line, String word, Map<String, Integer> map){
        if (line.toLowerCase().contains(word.toLowerCase())) {
            Integer prevValue = map.get(word);
            map.put(word, prevValue + 1);
        }
    }

    private Map<String, Integer> setupMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, 0);
        }
        return map;
    }

}
