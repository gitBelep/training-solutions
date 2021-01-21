package week02d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
//List<char[]> cList = Arrays.asList(new char[]{'J', 'a', 'v', 'a'}, new char[]{'P', 'y', 't', 'h', 'o', 'n'}, new char[]{ 'J', 'a', 'v', 'a', 'S', 'c', 'r', 'i', 'p', 't'});
// Ez karaktertömbök listája
        List<String> sList = Arrays.asList("Java", "Python", "JavaScript");
        for (String s : sList) {
            if (s.length() > 5) {
                System.out.print(s + " ");
            }
        }
    }
}
