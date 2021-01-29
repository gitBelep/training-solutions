package week13d05;

import java.util.HashSet;
import java.util.Set;

public class UniqueLetter {

    public int countUniqueLetters(String incoming){
        char[] word = incoming.toLowerCase().trim().toCharArray();
        Set<Character> uniqueLetters = new HashSet<>();
        for (char c : word){
            if ('a' <= c && c <= 'z'){
                uniqueLetters.add(c);
            }
        }
        return uniqueLetters.size();
    }
}

//if ( Character.isLetter() ){ } -ékezeteseket is elfogad
//vagy regex-szel:  replaceAll("[^a-z]","");
//cseréld, ami nem a-z-közt van, semmire.
//
//replaceAll("[\\W\\d\\s]",""
//W = nem betű, d = szám, s = whitespace
