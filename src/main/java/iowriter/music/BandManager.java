package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
    private List<Band> bandList = new ArrayList<>();

    public void readBandsFromFile(Path path){
        try ( BufferedReader br = Files.newBufferedReader(path) ){
            String line = "";
            while ( (line = br.readLine()) != null ){
                String[] bandDatas = line.split(";");
                int yearOfEstablishing = Integer.parseInt(bandDatas[1]);
                bandList.add(new Band(bandDatas[0], yearOfEstablishing));
            }
        } catch (IOException | NumberFormatException e){
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public void writeBandsBefore(Path path, int year){
        try (BufferedWriter br = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            for (Band band : bandList) {
                if (band.getYear() < year) {
                    br.write( band.getName() +";"+ band.getYear() +"\n");
                }
            }
        } catch (IOException e){
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public List<Band> getBandList() {
        return new ArrayList<>(bandList);
    }

    public static void main(String[] args) {
        final Path sourcePath1 = Path.of("bands_and_years.txt");
        BandManager bm = new BandManager();
        bm.readBandsFromFile(sourcePath1);
//Mindkét megadás működik Windowson:
        Path pathTo = Path.of("src\\test\\resources\\bands_and_years2.txt");
        Path pathToW = Path.of("src","test", "resources", "bands_and_years2.txt");

        bm.writeBandsBefore(pathToW, 1999);
//Kreálhatok itt is Path-t:
        bm.writeBandsBefore(Path.of("fogdoki.txt"), 1999);
    }

}
