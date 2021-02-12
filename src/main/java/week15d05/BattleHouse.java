package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BattleHouse {
    private Map<String, Integer> houses = new HashMap<>();

    public List<String> findHousesWithMostBattles(){
        Path path = Path.of("src","main","resources", "week15d05_csata.csv");
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                findHhouses(line);
            }
            return houseCounter();
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void findHhouses(String line){
        String[] allParts = line.split(",");
        String[] parts = new String[8];
        System.arraycopy(allParts, 5, parts,0,8);
//      String[] parts = new String[]{a[5],a[6],a[7],a[8],a[9],a[10],a[11],a[12]};
        for (String house : parts) {
            if (house.length() > 3) {    //for 5~12{ if (!house.isBlank()
                if (!houses.containsKey(house)) {
                    houses.put(house, 0);
                }
                houses.put(house,houses.get(house) + 1);
            }
        }
    }

    private List<String> houseCounter(){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {    //max keresés kétszer
            int max = 0;
            String house = "";
            for (Map.Entry<String,Integer> e : houses.entrySet()) {
                if (e.getValue() > max) {
                    max = e.getValue();
                    house = e.getKey();
                }
            }
            result.add(house +": "+ houses.get(house));
            houses.remove(house);
        }
        return result;
    }

    public static void main(String[] args) {
        BattleHouse battleHouse = new BattleHouse();
        System.out.println(battleHouse.findHousesWithMostBattles());
        //[Lannister: 18, Stark: 16]
    }
}
