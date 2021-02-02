package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Shopping {
    private Map<String, Set<String>> productList = new HashMap<>();

    public void readFile(String path){
        Path file = Path.of(path);
        try (BufferedReader br = Files.newBufferedReader(file)){
            String line;
            while((line = br.readLine()) != null){
                String[] arr = line.split(" ");
                String code = arr[0];
                String[] item = arr[1].split(",");
                Set<String> products = new TreeSet<>(Arrays.asList(item));
                productList.put(code, products);
            }
        } catch (IOException e){
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public Set<String> getItems(String key){
        return productList.get(key);
    }

    public int sumOfDelivered(String product){
        int counter = 0;
        for (Set<String> s : productList.values()){
            if (s.contains(product)){
                counter++;
            }
        }
        return counter;
    }

    public int itemsOnList(String key){
        return productList.get(key).size();
    }

    public Map<String, Integer> statistics(){
        Map<String, Integer> result = new TreeMap<>();
        for (Set<String> s : productList.values()){
            for (String ss : s){
                if (result.containsKey(ss)){
                    int value = result.get(ss);
                    result.put(ss, value+1);
                } else {
                    result.put(ss, 1);
                }
            }
        }
        return result;
    }

}
