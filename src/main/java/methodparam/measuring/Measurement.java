package methodparam.measuring;

public class Measurement {
    private double[] values;

    public Measurement(double[] values) {
        this.values = values;
    }

    public int findFirstIndexInLimit(int lower, int upper){
        for (int i = 0; i < values.length; i++){
            if (lower < values[i] && values[i] < upper){
                return i;
            }
        }
        return -1;
    }

    public double minimum(){
        double min = Double.MAX_VALUE;
        for ( double d : values){
            if ( d < min ){
                min = d;
            }
        }
        return min;
    }

    public double maximum(){
        double max = Double.MIN_VALUE;
        for ( double d : values){
            if ( max < d){
                max = d;
            }
        }
        return max;
    }

    public ExtremValues minmax(){
        return new ExtremValues(maximum(), minimum());
    }
}
