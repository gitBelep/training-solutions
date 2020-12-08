package objectclass;
import java.util.ArrayList;
import java.util.List;

public class SimpleBag {
    private List<Object> items = new ArrayList<>();
    private int cursor = -1;

    public SimpleBag(){     }

    public void putItem(Object item){
        items.add(item);
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public int size(){
        return items.size();
    }

    public boolean contains(Object item){
        return items.contains(item);
    }

    public void beforeFirst(){
        cursor = -1;
    }

    public boolean hasNext(){
        return (items.size() > cursor+1);
    }

    public Object next(){
        cursor++;
        return items.get(cursor);
    }

    public int getCursor(){
        return cursor;
    }
}
