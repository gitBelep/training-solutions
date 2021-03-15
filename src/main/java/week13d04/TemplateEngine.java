package week13d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {

    public void merge(BufferedReader br, Map<String, Object> data, BufferedWriter bw) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            for (Map.Entry<String, Object> m : data.entrySet()) {
                String s = m.getKey();
                if (line.contains(s)) {
                    line = line.replace(s, data.get(s).toString());
                }
            }
            bw.write(line + "\n");
        }
    }

    public static void main(String[] args) {
        TemplateEngine t = new TemplateEngine();
        Map<String, Object> data = new HashMap<>();
        data.put("{nev}","Aba Sámuel");
        data.put("{datum}", LocalDate.now().toString());
        data.put("{osszeg}",2980);
        data.put("{hatarido}",LocalDate.now().plusDays(8L));

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                TemplateEngine.class.getResourceAsStream("/w13d04_Template.txt")));
             BufferedWriter bw = Files.newBufferedWriter(
                     Path.of("d:", "w13d04_Korlevel.txt")) //, StandardOpenOption.APPEND)
        ) {

            t.merge(br, data, bw);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

}
