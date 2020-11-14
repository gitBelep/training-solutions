package controliteration.dictionary;
import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {
    private String wordHun;
    private List<String> english;

    public DictionaryItem(String wordHun,List<String> english){
        this.wordHun = wordHun;
        this.english = english;
    }

    public String getWordHun() {
        return wordHun;
    }
    public List<String> getEnglish() {
        return english;
    }
    public void addToEnglish(String eng) {
        this.english.add(eng);
    }
}
