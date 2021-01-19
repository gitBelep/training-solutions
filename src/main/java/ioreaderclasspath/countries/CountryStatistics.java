package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    private List<Country> countryList = new ArrayList<>();

    public void readFromFile(String str){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream(str)))){
            String line;
            while ( (line = br.readLine()) != null){
                String[] tempCountry = line.split(" ");
                int tempBorder = Integer.parseInt(tempCountry[1]);
                countryList.add(new Country(tempCountry[0], tempBorder));
            }
        } catch (IOException | NumberFormatException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public int numberOFCountries(){
        return countryList.size();
    }

    public Country mostBorderCountries(){
        int max = 0;
        String nameOfCountry = "";
        for (Country c : countryList){
            if (c.getBorderCountries() > max){
                max = c.getBorderCountries();
                nameOfCountry = c.getName();
            }
        }
        return new Country(nameOfCountry, max);
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }
}
