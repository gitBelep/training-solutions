package methodparam.measuring;

public class ExtremValues {
    private final double max;
    private final double min;

    public ExtremValues(double max, double min) {
        this.max = max;
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }
}
