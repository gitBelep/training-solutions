package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    List<CoffeeOrder> coffeeList;

    public Cafe() {
        this.coffeeList = new ArrayList<>();
    }

    public Cafe(List<CoffeeOrder> coffeeList) {
        this.coffeeList = coffeeList;
    }

    //    public BigDecimal getTotalIncome(){
//        BigDecimal sum = new BigDecimal("0");
//        for (CoffeeOrder co : coffeeList){
//            for (Coffee c : co.getCoffeeList()){
//                sum = sum.add(c.getPrice());
//            }
//        }
//        return sum.setScale(2, RoundingMode.HALF_UP);
//    }
    public BigDecimal getTotalIncome() {
        return coffeeList.stream()
                .flatMap(co -> co.getCoffeeList().stream())
                .map(kv -> kv.getPrice())
                .reduce(new BigDecimal(0), (a,b) -> a.add(b)).setScale(2, RoundingMode.HALF_UP);
    }                   //BigDecimal.ZERO szebb. A "0" alapérték nem jó BigD miatt!

    public BigDecimal getTotalIncome(LocalDate date){
        return coffeeList.stream()
                .filter(co -> co.getDateTime().toLocalDate().equals(date))
                .flatMap(co -> co.getCoffeeList().stream())
                .map(kv -> kv.getPrice())
                .reduce(BigDecimal.ZERO, (a,b) -> a.add(b).setScale(2, RoundingMode.HALF_UP));
    }

    public Long getNumberOfCoffee(CoffeeType type){
        return coffeeList.stream()
            .flatMap(co -> co.getCoffeeList().stream())
            .filter(ca -> ca.getType() == type)
            .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from){
        return coffeeList.stream()
            .filter(co -> co.getDateTime().isAfter(from))
            .collect(Collectors.toList());
// vagy     .collect(ArrayList::new, List::add, List::addAll);
    }

//    getFirstFiveOrder(LocalDate date): adott napon az első 5 vásárlásban lévő kávék listája
    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date){
        return coffeeList.stream()
            .filter(co -> co.getDateTime().toLocalDate().equals(date))
// ez miért nem?  .sorted(CoffeeOrder::getDateTime)
            .sorted((co1, co2) -> co1.getDateTime().compareTo(co2.getDateTime()))
            .limit(5L)
            .collect(ArrayList::new, List::add, List::addAll);
    }

    public List<CoffeeOrder> getCoffeeList() {
        return new ArrayList<>(coffeeList);
    }

    public void addOrder(CoffeeOrder coffeeOrder){
        coffeeList.add(coffeeOrder);
    }

}
