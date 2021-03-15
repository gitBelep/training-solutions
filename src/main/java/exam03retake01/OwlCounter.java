package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {
    private Map<String,Integer> owls = new HashMap<>();

    public void readFromFile(BufferedReader br) throws IOException {
        String line;
        while( (line = br.readLine()) != null){
            String[] datas = line.split("=");
            owls.put(datas[0], Integer.parseInt(datas[1]));
        }
    }

    public int getNumberOfOwls(String megye){
        if (owls.keySet().contains(megye)) {
            return owls.get(megye);
        }
//        for(Map.Entry m : owls.entrySet()){
//            if(m.getKey().equals(megye)){
//                return (int) m.getValue();
//            }
//        }
        throw new IllegalArgumentException("Nem létező megyenév");
    }

}
