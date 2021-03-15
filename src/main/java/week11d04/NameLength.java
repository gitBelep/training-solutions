package week11d04;

import java.util.*;

public class NameLength {
    public static void main(String[] args) {
        NameLength n = new NameLength();
        List<String> names = List.of("Joe", "Go", "Jack", "Jane", "Jake", "George", "William");
        System.out.println(names.toString());
        System.out.println(n.getLengths(names, "J").toString() +" \"J\"-vel");
        System.out.println(n.getLengthsStream(names, "J").toString() +" streammel");

        List<String> plants = List.of("apple", "pear", "alma", "agave", "A", "pea", "amerikai mogyoró");
        System.out.println(plants.toString());
        System.out.println(n.getLengths(plants, "a").toString() +" \"a\"-val");
        System.out.println(n.getLengthsStream(plants, "a").toString() +" streammel");
    }

    public Set<Integer> getLengths(List<String> names, String letter){
        Set<Integer> possibleLengths = new TreeSet<>();
        for(Iterator<String> i = names.iterator(); i.hasNext(); ){
            String actual = i.next();
            String firstLetter = actual.substring(0,1);
            if(firstLetter.equals(letter)){
                possibleLengths.add(actual.length());
            }
        }
        return possibleLengths;
    }

    public Set<Integer> getLengthsStream(List<String> names, String letter){
        return names.stream()
                .filter(s -> s.startsWith(letter))   //s -> s.substring(0,1).equals(letter))
                .map(s -> s.length())
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        }

}
