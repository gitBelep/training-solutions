package week14d01;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names){
        Map<Character, List<String>> nameMap = new TreeMap<>();
        for(String name : names){
            Character startLetter = name.charAt(0);
            if (nameMap.containsKey(startLetter)) {
                List<String> existing = nameMap.get(startLetter);
                existing.add(name);
                nameMap.put(startLetter, existing);
            } else {
                nameMap.put(startLetter, new ArrayList<>(Arrays.asList(name)));
            }
        }
        return nameMap;
    }

}
