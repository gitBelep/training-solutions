package interfacedefaultmethods.print;

public interface Printable {
    static String BLACK = "#000000";

    int getLength();

    String getPage(int p);

    default String getColor(int p){
        return "#000000";
    }
}
