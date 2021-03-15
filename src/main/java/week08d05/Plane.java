package week08d05;

import java.io.IOException;
import java.io.InputStreamReader;

public class Plane {

    public void messSee(String theMap) {
        try (InputStreamReader isr = new InputStreamReader(
                Plane.class.getResourceAsStream(theMap))) {
            char c;
            int sum = 0;
            int maxSee = 0;
            while ((c = (char) isr.read()) != (char) -1) {
                System.out.print(c);
                if (c == '0'){
                    sum++;
                }else{
                    if (maxSee < sum){
                        maxSee = sum;
                    }
                    sum = 0;
                }
            }
            System.out.println("\nA legnagyobb tenger hossza: "+ maxSee +" egység");
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public static void main(String[] args) {
        Plane plane = new Plane();
        plane.messSee("/week08d05Plane.txt");
    }
}
