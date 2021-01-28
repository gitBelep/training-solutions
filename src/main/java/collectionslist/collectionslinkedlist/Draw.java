package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (maxNumber <= drawCount) {
            throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
        }

//Az elegáns megoldás:  (nem csak az első drawCount darabot adhatom vissza)
//  return new TreeSet<>( makeNumberList(maxNumber) );

        Queue<Integer> numbers = makeNumberList(maxNumber);
        Set<Integer> result = new TreeSet<>();
        for (int i = 0; i< 5; i++){
            result.add(numbers.poll());
        }
        return result;
    }

    private LinkedList<Integer> makeNumberList(int maxNumber){
        List<Integer> balls = new LinkedList<>();
        for (int i = 1; i <= maxNumber; i++){
            balls.add(i);
        }
        Collections.shuffle(balls);
        return (LinkedList<Integer>) balls;
    }

}
