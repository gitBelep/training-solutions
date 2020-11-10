package typeconversion.dataloss;

public class DataLoss {
    private int i=0;
    private Float fl;
    private long second;

    public void dataLoss(){
        for (long first=0; i<3; first++){
            fl = (float) first;
            second = fl.longValue();
            if (first != second){
                System.out.println("eredeti:  "+ first + "  binary: "+ Long.toBinaryString(first));
                System.out.println("új érték: "+ second + "  binary: "+ Long.toBinaryString(second));
                i++;
            }
        }
    }

    public static void main(String[] args) {
        new DataLoss().dataLoss();
    }
}
