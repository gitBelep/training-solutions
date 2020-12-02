package week06d03;
import java.util.Scanner;

public class WordEraser {

    public String eraseWord(String words, String word){
        String rest = words;
        String shortStr = "";
        String cut = "";

        while (rest.contains(" ")) {
            cut = rest.substring(0, rest.indexOf(" "));
            if (!word.equals(cut)) {
                shortStr = shortStr + " " + cut;
            }
                rest = rest.substring(rest.indexOf(" ")+1);
        }
            return (shortStr +" "+ rest).trim();
    }

    public String eraseWordWithStringBuilder(String words, String word){
        String[] sentence = words.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String s : sentence){
            if ( !word.equals(s) ){
                sb.append(s +" ");
            }
        }
        return sb.toString().trim();
    }

    public String eraseWithScanner(String words, String word){
        Scanner sc = new Scanner(words);
        StringBuilder sb = new StringBuilder();
        String text = "";

        while (sc.hasNext()) {
            text = sc.next();
            if ( !word.equals(text) ){
                sb.append(text +" ");
            }
        }
        return sb.toString().trim();
    }
}
