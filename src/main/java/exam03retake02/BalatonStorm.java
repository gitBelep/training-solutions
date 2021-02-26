package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader br) throws IOException {
        String line;
        Collator huCollator = Collator.getInstance(new Locale("hu", "HU"));
        Set<String> stormyStations = new TreeSet<>(huCollator);
        while ((line = br.readLine())  != null) {
            if (line.contains("allomas")){
                String[] parts = line.split(":");
                String stationName = parts[1].substring(2, parts[1].lastIndexOf('\"'));
                skipThreeLines(br);
                parts = br.readLine().split(":");
                int level = Integer.parseInt( parts[1].substring(1,2) );
                if(level == 3){
                    stormyStations.add(stationName);
                }
                skipThreeLines(br);
            }
        }
        return new ArrayList<>(stormyStations);
    }

    private void skipThreeLines(BufferedReader br) throws IOException{
        br.readLine();
        br.readLine();
        br.readLine();
    }

}
