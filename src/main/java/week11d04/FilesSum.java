package week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    public int sumNumbers() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
//fűzz a névbe 0-át!     Vagy:   = String.format("number%02d.txt", i);
            String filenameStr = "number" + (i < 10 ? "0" + i : i) + ".txt";
            Path filePath = Path.of(filenameStr);
            if (Files.isRegularFile(filePath)) {
                sum += readFile(filenameStr);
            }
        }
        System.out.println("Kell: \"240 + 317 = 557\", valójában sum = " + sum);
        return sum;
    }

    private int readFile(String name) {
        try {
            String fileContent = Files.readString(Path.of(name));
            return Integer.parseInt(fileContent);
        } catch (IOException | NumberFormatException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}

/* Hosszú:    if (i < 10){
 *                ii = "number0"+ i +".txt";
 *            } else {
 *                ii = "number"+ i +".txt";
 *            }
 */

/*
Adott az aktuális könyvtárban több, fájl, melynek a nevei: number00.txt,
number03.txt, number20.txt, egészen 99-ig. Nem minden fájl létezik,
lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az
állományból a benne lévő számot, és ezt összegezd! Használd a
Files.isRegularFile() metódust arra, hogy megnézd, létezik-e a fájl!
Használd a Files.readString() metódust a fájl beolvasására!
 */