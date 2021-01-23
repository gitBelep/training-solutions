package introconstructors;

import java.util.Arrays;
import java.util.List;

public class Restaurant {
    private List<String> menu;
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables){
        this.name = name;
        capacity = numberOfTables * 4;
        loadMenu();
    }

    private void loadMenu(){
        menu = Arrays.asList("Gyümölcsleves", "Mákos tészta", "Bejgli");
    }

    public String getMenu() {
        return menu.toString();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
