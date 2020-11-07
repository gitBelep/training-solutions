package arraylist;
import java.util.ArrayList;
import java.util.List;

public class Capsules {
    private List<String> colors = new ArrayList<>();

    public void addLast(String s) {
            colors.add(colors.size(),s);
    }

    public void addFirst(String s) {
        colors.add(0,s);
    }

    public void removeFirst() {
        colors.remove(0);
    }

    public void removeLast() {
        int m = colors.size();
        colors.remove(m-1);
    }

    public List<String> getColors() {
        return colors;
    }

    public static void main(String[] args) {
        Capsules caps = new Capsules();
        caps.addLast("blue");
        caps.addLast("red");
        caps.addLast("blue");
        caps.addLast("xyellow");
        caps.addFirst("yellow");
        caps.addFirst("black");
        caps.addFirst("xyellow");
        System.out.println(caps.getColors());
        caps.removeFirst();
        caps.removeLast();
        System.out.println(caps.getColors());

        List<String> second = caps.getColors();
        second.clear(); //referencia az eredeti colors Objektumra mutat
        System.out.println(caps.getColors());
    }
}
