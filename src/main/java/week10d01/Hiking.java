package week10d01;

import java.util.List;

public class Hiking {

    public double getPlusElevation(double[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Values is empty");
        }
        double increase = 0;
        double temp = values[0];
        for (double d : values) {
            if (d > temp) {
                increase += d - temp;
            }
            temp = d;
        }
        return increase;
    }

    public double getPlusElevation(List<Double> values) {          //Overload
        if (values == null || values.size() == 0) {
            throw new IllegalArgumentException("Values is empty");
        }
        double increase = 0;
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) > values.get(i - 1)) {
                increase += values.get(i) - values.get(i - 1);
            }
        }
        return increase;
    }

}
