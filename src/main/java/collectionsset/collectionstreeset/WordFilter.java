package collectionsset.collectionstreeset;

import java.util.*;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings){

        Set<String> result = new TreeSet<>(Arrays.asList(randomStrings));

        System.out.println("Rendezett mérete < eredeti: "+ result.size() + " < "+ randomStrings.length);

        Deque<String> firstLast = new LinkedList<>(result);
        System.out.println("első elem: "+ firstLast.peekFirst() +", utolsó elem: "+ firstLast.peekLast());

        return result;
    }

}
