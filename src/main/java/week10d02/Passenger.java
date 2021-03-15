package week10d02;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Passenger {

    public int getStopWithMax(InputStream ist) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(ist))){
            String line;
            Map<String, Integer> stops = new TreeMap<>();
            while ( (line = br.readLine()) != null){
                String[] data = line.split(" ");
                String stop = data[0].trim();
                if(stops.keySet().contains(stop)){
                    stops.put(stop, stops.get(stop)+1);
                }else{
                    stops.put(stop, 1);
                }
            }
            System.out.println("Megállók és várakozók "+ stops.toString());
            String resultStop = findMax(stops);
            return stops.get(resultStop);
        }
    }

    private String findMax(Map<String, Integer> stops){
        int max = 0;
        String stopNameKey = "";
        for (Map.Entry<String, Integer> e : stops.entrySet()){
            if (max < e.getValue()){
                max = e.getValue();
                stopNameKey = e.getKey();
            }
        }
        System.out.print("Legtöbben a \""+ stopNameKey +"\" megállóban várakoztak: ");
        return stopNameKey;
    }

    public static void main(String[] args) {
        Passenger passenger = new Passenger();
        try (InputStream ist = Passenger.class.getResourceAsStream("/week10d02_utasadat.txt")){
            System.out.println(passenger.getStopWithMax(ist));
        } catch (IOException e) {
            System.out.println("Cannot read file");
        }
    }

}
