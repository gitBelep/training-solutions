package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Covid {

    public int letsFindWord(String word, BufferedReader br) throws IOException {
        int counter = 0;
        String line;
        while ((line = br.readLine()) != null) {
            if (line.toLowerCase().contains(word.toLowerCase())) {  // .indexOf() >= 0){  //uúgy működik
                counter++;
            }
        }
        return counter;
    }


    public static void main(String[] args) {
        String searchedWord = "koronavírus";

        System.out.println("Hány sorban szerepel (mindegy, hányszor) az adott szó: "+ searchedWord);
        Covid c = new Covid();

//közvetlenül, élőben a netről
        try {
            URL url = new URL("https://index.hu");
            InputStream ins = url.openStream();
            int counted = c.letsFindWord(searchedWord, new BufferedReader(
                    new InputStreamReader(ins)));
            System.out.println(counted +" most épp a Neten az \"index.hu\" oldalon");
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

//egy mappában. Csak, h ne legyen teleszemetelve a gép.
        Path file = Path.of("c:", "training", "training-solutions", "index.html");
        try (BufferedReader br = Files.newBufferedReader(file)) {
            int counted = c.letsFindWord(searchedWord, br);
            System.out.println(counted);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

//classpathról. Másik file.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Covid.class.getResourceAsStream("/Index.html")))) {
            int counted = c.letsFindWord(searchedWord, br);
            System.out.println(counted);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

    }
}

