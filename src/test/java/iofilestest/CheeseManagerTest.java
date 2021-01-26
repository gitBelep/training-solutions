package iofilestest;

import iofiles.Installer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheeseManagerTest {

    @TempDir
    public File folder;

    @Test
    void testSaveToFileAndReadIt() {
        CheeseManager cheeseM = new CheeseManager();
        Path targetPath = folder.toPath().resolve("sajt.dat");

        List<Cheese> sajtok = new ArrayList<>();
        sajtok.add(new Cheese("Ementáli", 1.1));
        sajtok.add(new Cheese("Trappista", 2.2));
        sajtok.add(new Cheese("Tilsiter", 3.3));
        sajtok.add(new Cheese("Mozzarella", 4.4));
        sajtok.add(new Cheese("Mackó", 5.5));

        cheeseM.saveToFile(sajtok, targetPath);

        assertEquals(5.5, cheeseM.findCheese("Mackó", targetPath).getLactose());
        assertEquals(3.3, cheeseM.findCheese("Tilsiter", targetPath).getLactose());

    }

    @Test
    void lathatoTest() {
        CheeseManager cheeseM = new CheeseManager();

        List<Cheese> sajtok = new ArrayList<>();
        sajtok.add(new Cheese("Ementáli", 1.1));
        sajtok.add(new Cheese("Trappista", 2.2));
        sajtok.add(new Cheese("Tilsiter", 3.3));
        sajtok.add(new Cheese("Mozzarella", 4.4));
        sajtok.add(new Cheese("Mackó", 5.5));

        Path cel = Path.of("src/main/resources/sajtok.dat");

        cheeseM.saveToFile(sajtok, cel);

        assertEquals(5.5, cheeseM.findCheese("Mackó", cel).getLactose());
        assertEquals(3.3, cheeseM.findCheese("Tilsiter", cel).getLactose());
    }
}