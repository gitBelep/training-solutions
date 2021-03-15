package week16d01;

public enum CanoeType {
    RED(1), GREEN(1.2), BLUE(1.5);

    final double colourPrice;

    CanoeType(double colourPrice) {
        this.colourPrice = colourPrice;
    }
}
