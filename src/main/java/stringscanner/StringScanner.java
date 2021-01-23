package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter){
        if (isEmpty(intString) ){
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        int sum = 0;
        delimiter = (isEmpty(delimiter)) ? " " : delimiter;
        try (Scanner sc = new Scanner(intString).useDelimiter(delimiter)){
            while (sc.hasNext()){
                 int num = sc.nextInt();
                 sum += num;
            }
        } catch ( InputMismatchException e){
            throw new IllegalArgumentException("Incorrect parameter string!", e);
        }
        return sum;
    }

    public int readAndSumValues(String intString){
        return readAndSumValues(intString, " ");
    }

    public String filterLinesWithWordOccurrences(String text, String word){
        if (isEmpty(text) || isEmpty(word) || "".equals(text.trim())){
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        StringBuilder result = new StringBuilder();
        try (Scanner sc = new Scanner(text)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (line.contains(word)){
                    result.append( line +"\n");
                }
            }
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        if (result.length() < 1){
            return result.toString();
        } else {
            return result.substring(0, result.length() - 1);
        }
    }

    private boolean isEmpty(String s){
        return (s == null || "".equals(s));
    }

}
