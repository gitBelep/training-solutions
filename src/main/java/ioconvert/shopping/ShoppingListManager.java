package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream os, List<String> shopping){
        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os))) {
            for (String s : shopping){
                br.write(s); //(s +"\n")  ??
                br.newLine();
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    public List<String> loadShoppingList(InputStream ins){
        List<String> shopList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(ins))){
            String line;
            while ( (line = br.readLine()) != null) {
                shopList.add(line);
            }
            return shopList;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }
    }
}
