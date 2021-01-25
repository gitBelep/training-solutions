package week13d01;

import java.io.*;
import java.net.URL;

//szép megoldás az órai munka alapján, és alul az eredetim
public class Town {

    //ez csak egy try-catch blokk, a többszörös beágyazás kiszervezve
    public String searchTheLongest(BufferedReader br) {
        try {
            skipHeader(br);
            String result = reviseTownList(br);
            return result +" hossza: " + result.length();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read line", e);
        }
    }

    //itt nincs try-catch, hiszen akkor mire való ez a blokk -> throws
    private String reviseTownList(BufferedReader br) throws IOException {
        int index = 2;
        String maxTownName = "";
        String line = "";
        while ((line = br.readLine()) != null) {
            String town = getTownFromLine(line, index);
            index++;
            if (town.length() > maxTownName.length()) {
                maxTownName = town;
            }
        }
        return maxTownName;
    }

    //külön feladata van
    private String getTownFromLine(String line, int number) {
        String[] parts = line.split(";");
        if (parts.length <= 1) {
            throw new IllegalArgumentException("Illegal line " + number + ". :\"" + line + "\"");
        }
        String town = parts[1];
        if (town.length() < 2){
            throw new IllegalArgumentException("No such town: \""+ town +"\"");
        }
        return town;
    }

    //olvashatóbb a kód, ha magyarázat helyett kiszervezem
    private void skipHeader(BufferedReader br) throws IOException {
        br.readLine();
    }


    public String searchTheLongestSajat(BufferedReader br) {
        int max = 0;
        String maxLine = "";
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                String[] a = line.split(";");
                if (a[1].length() > max) {
                    max = a[1].length();
                    maxLine = a[1];
                }
            }
            return maxLine + " hossza: " + max;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read line", e);
        }
    }

    public static void main(String[] args) {
        Town town = new Town();
        try (BufferedReader brClasspath = new BufferedReader(new InputStreamReader(Town.class.getResourceAsStream("/varosW13d01.csv")))) {
            System.out.println("Classpath-ról:");
            System.out.println(town.searchTheLongest(brClasspath));

            URL url = new URL("https://raw.githubusercontent.com/Training360/strukturavalto-java-public/master/examples/week13d01/src/main/resources/iranyitoszamok-varosok-2021.csv");
            InputStream insNet = url.openStream();
            BufferedReader brNet = new BufferedReader(new InputStreamReader(insNet));
            System.out.println("Internetről:");
            System.out.println(town.searchTheLongestSajat(brNet));

        } catch ( IOException | NullPointerException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

    }
}
