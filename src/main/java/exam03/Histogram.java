package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

        public String createHistogram(BufferedReader br) throws IOException {
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine())  != null) {
                int t = Integer.parseInt(line);
                for (int i = 0; i < t; i++) {
                    result.append("*");
                }
                result.append("\n");
            }
            return result.toString();
        }

}
