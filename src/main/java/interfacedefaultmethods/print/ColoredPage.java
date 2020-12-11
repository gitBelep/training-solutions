package interfacedefaultmethods.print;

public class ColoredPage {
    private final String contetnt;
    private final String color;

    public ColoredPage(String contetnt, String color) {
        this.contetnt = contetnt;
        this.color = color;
    }

    public String getContetnt() {
        return contetnt;
    }

    public String getColor() {
        return color;
    }
}
