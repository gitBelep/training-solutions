package constructoroverloading.bus;
import java.util.*;

public class BusTimeTable {
    private List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable){
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute){
        for (int i = firstHour; i <= lastHour; i++){
            timeTable.add( new SimpleTime(i,everyMinute) );
        }
    }

    public List<SimpleTime> getTimeTable(){
        return timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual){
        int[] minTimeTable = sorter();
        int intResult = -1;
        for (int i = 0; i < minTimeTable.length; i++){
            if (minTimeTable[i] >= actual.getInMinutes()){
                intResult = minTimeTable[i];
                break;
            }
        }
        if (intResult == -1){
            throw new IllegalStateException("No more buses today!");
        }
        return new SimpleTime( intResult /60,intResult % 60);
    }

    public SimpleTime firstBus(){
        int[] minTimeTable = sorter();
        int intResult = minTimeTable[0];
        return new SimpleTime( intResult /60,intResult % 60);
    }

    private int[] sorter() {
        int[] minTimeTable = new int[timeTable.size()];
        for (int i = 0; i < timeTable.size(); i++) {
            minTimeTable[i] = timeTable.get(i).getInMinutes();
        }
        Arrays.sort(minTimeTable);
        return minTimeTable;
    }
}
