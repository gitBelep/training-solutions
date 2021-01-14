package ioreadwritebytes.temperatures;
import java.util.Random;

public class Temperatures {
    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public double getYearAverage(){
        double average = 0.0;
        for(byte b : data){
            average += b;
        }
        return average / data.length;
    }

    public double getMonthAverage(){
        double average = 0.0;
        for (int i = data.length-30; i < data.length; i++){
            average += data[i];
        }
        return average / 30;
    }

    public byte[] getData() {
        return data;
    }


    public static void main(String[] args) {

        byte[] data = new byte[365];
        Random random = new Random(1);
        random.nextBytes(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] +" ");
            if ((i+1) % 50 ==0){ System.out.println(); }
        }
        System.out.println("\nEz volt az eredeti. Kiírom. Visszaolvasom.\n");

        TemperaturesWriter tWriter = new TemperaturesWriter();
        Temperatures temperatures = new Temperatures(data);
        TemperaturesReader tReader = new TemperaturesReader();
        String path = "2022.dat";

        tWriter.writeTemperatures(temperatures, path);
        Temperatures result = tReader.readTemperatures(path);

        System.out.println("Ez a visszaolvasott:");
        for (int i = 0; i < result.getData().length; i++) {
            System.out.print(result.getData()[i] +" ");
            if ((i+1) % 50 ==0){ System.out.println(); }
        }
    }
}
