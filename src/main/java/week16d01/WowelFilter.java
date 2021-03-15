package week16d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WowelFilter {

    public String filterWowels(BufferedReader br) throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine())  != null) {
            String wowels = "aáeéiíoóöőuúüűAÁEÉIÍOÓÖŐUÚÜŰ";
            for (char c : line.toCharArray()){
                if(!wowels.contains(Character.toString(c))){
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WowelFilter w = new WowelFilter();
        try (BufferedReader br = Files.newBufferedReader(Path.of("src","main","resources","w16d01vizsga.txt"))) {
            System.out.println( w.filterWowels(br) );
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }
}
