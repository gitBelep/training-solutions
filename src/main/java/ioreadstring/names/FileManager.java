package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
//vigyázat: file nem a normál resources könyvtárban van!!

public class FileManager {
    private Path myFile;
    private List<Human> humans = new ArrayList<>();

    public FileManager(String myFile) {
        this.myFile = Path.of(myFile);    //miért nem new Path() ??
    }

    public void readFromFile(){
        try{
            List<String> humanList = Files.readAllLines(myFile);
            makeHumans(humanList);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void makeHumans(List<String> strHumans){
        for (String s : strHumans){
            String[] names = s.split(" ");
            humans.add(new Human(names[0], names[1]));
        }
    }

    public Path getMyFile() {
        return myFile;
    }

    public List<Human> getHumans() {
        return new ArrayList<>(humans);
    }
}
