package week10d01;

public class Hiking {

    public double getPlusElevation(double[] values){
        if (values == null || values.length == 0){
            throw new IllegalArgumentException("Values is empty");
        }
        double increase = 0;
        double temp = values[0];
        for (double d : values){
            if (d > temp){
                increase += d - temp;
            }
            temp = d;
        }
        return increase;
    }

}
