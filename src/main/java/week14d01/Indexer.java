package week14d01;
import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> nameMap = new TreeMap<>();
        for (String name : names) {
            Character startLetter = name.charAt(0);
            if (!nameMap.containsKey(startLetter)) {
                nameMap.put(startLetter, new ArrayList<>(Arrays.asList(name)));
            } else {
                List<String> existing = nameMap.get(startLetter);
                existing.add(name);
                nameMap.put(startLetter, existing);
            }
        }
        return nameMap;
    }

    public Map<Character, List<String>> indexNincsTulaggodva(List<String> names) {
        Map<Character, List<String>> nameMap = new TreeMap<>();
        for (String name : names) {
            Character startLetter = name.charAt(0);
            if (!nameMap.containsKey(startLetter)) {
                nameMap.put(startLetter, new ArrayList<>());  //üresen
            }
            nameMap.get(startLetter).add(name);  //cska hozzáadok a List-hez.
        }                     //nem kell put-tal visszatenni, megváltoztattam
        return nameMap;
    }

}
