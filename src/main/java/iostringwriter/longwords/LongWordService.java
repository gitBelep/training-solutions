package iostringwriter.longwords;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    public String writeWithStringWriter(List<String> words) {
        String result = "";
        StringWriter sw = new StringWriter();
        try (sw) {
            result = writeW(words, sw);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String writeW(List<String> words, Writer wr) {
        try {
            for (String s : words) {
                wr.write(s + ";");
                wr.write( Integer.toString(s.length()) +"\n");
            }
            System.out.print(wr.toString());
            return wr.toString();
        } catch (IOException ex) {
                throw new IllegalStateException("Cannot read file", ex);
            }
    }

}
