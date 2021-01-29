package collectionsset.collectionshashset;

import java.util.*;

public class StringsHandler {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection){
        return new HashSet<>(stringCollection);
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB){
// Megoldás:        setA.retainAll(setB); return setA;

        Set<String> identicalStrings = new HashSet<>();
        for (String s : setA){
            int priorSize = setB.size();
            setB.add(s);
            if (setB.size() == priorSize){
                identicalStrings.add(s);
            }
        }
        return identicalStrings;
    }

}
