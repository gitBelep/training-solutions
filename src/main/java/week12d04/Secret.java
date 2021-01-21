package week12d04;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Secret {

    public void loadSecret() {
        Path file = Path.of("secret.dat");
        try (InputStream ins = new BufferedInputStream(Files.newInputStream(file))) {
            byte[] bytes = ins.readAllBytes();
            encodeSecret(bytes);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private void encodeSecret(byte[] secret){
        List<Character> text = new ArrayList<>();
        for(byte b : secret){
            char c = (char)((byte) (b + 10));
            text.add(c);
        }
        System.out.println(text.toString());
    }
}