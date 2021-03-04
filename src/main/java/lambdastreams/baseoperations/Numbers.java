package lambdastreams.baseoperations;

import java.util.*;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Optional<Integer> min(){
        Optional<Integer> min = numbers.stream()
                .min(Comparator.naturalOrder());
//vagy:         .min((n1, n2) -> n1.compareTo(n2));
        return min;
    }

    public Integer sum(){
        return numbers.stream()
                .reduce(0, (a,i) -> a + i);
    }

    public Set<Integer> getDistinctElements(){
        return numbers.stream()
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }

    public boolean isAllPositive(){
        return numbers.stream()
        .allMatch(i -> i >= 0);
    }

    public int sumOfNegatives(){
        return numbers.stream()
                .reduce(0, (a, i) -> {  //Integer-ök
                    if(i < 0){
                        a = a + i;
                    }
                    return a;
                });
    }

    public long countNegatives(){
        return numbers.stream()
                .filter(i -> i < 0)
                .count();
    }

}
