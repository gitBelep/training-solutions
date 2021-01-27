package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Disposition {

    public int classesPerWeek(String teacherName) {
        int numberOfClasses = 0;
        try (BufferedReader br = Files.newBufferedReader(Path.of("src/main/resources/week13d03beosztas.txt"))){
            String line;
            while((line = br.readLine()) != null) {
                if (teacherName.equals(line)) {
                    numberOfClasses += countClasses(br);
                } else {
//nem muß, hagyhatom, h ellenőrizzen minden sort, h tanárnév-egyezés van-e
                    jumpToNextTeacher(br);
                }
            }
        } catch (IOException | NumberFormatException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return numberOfClasses;
    }

    private int countClasses(BufferedReader br) throws IOException {
        br.readLine();
        br.readLine();
        return Integer.parseInt( br.readLine());
    }

    private void jumpToNextTeacher(BufferedReader br) throws IOException{
        br.readLine();
        br.readLine();
        br.readLine();
    }
}

//Adott a week13d03beosztas.txt fájl, tantárgyfelosztást tartalmaz, 4-es blokkokban.
//Első sor a *tanár neve, majd a *tantárgy, majd az *osztály ahol tanítja és végül az, hogy
//*heti hány órában. Írj egy metódust, ami paraméterül várja egy tanár nevét, és kiírja,
//hogy hány órája van egy héten.  ___Megoldások___
//1. Map-be beleolvasni rögtön a filet.
//Ha új tanár, beleteszi egyből, ha van már, akkor hozzáadja az óraszámot.
//Mappel olyan bonyolultat is egyszerű megoldani, mint "melyik tanár tartotta a legtöbb órát?"
//2. minden negyedik név. if akkor i+3 -dik elemet kérem, ++.
//____Ötlet_____ paraméterként nem kész Array:
//Str[] lines = new Str[4];
//while ((lines[0] = br.readLine()) != null){ }
//_
//private Subject processBlock(BuffRead br, Str[] block)
//for(i 1~3){ block[i] =  br.readLine();}
//return new Subj(block[0], ..stb)
