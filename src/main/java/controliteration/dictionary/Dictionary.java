package controliteration.dictionary;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {
    private List<DictionaryItem> translations = new ArrayList<>();

    public void addItem(String hun, List<String> eng) {
        List<String> huns = new ArrayList<>();
        for (DictionaryItem item : this.translations) {
            huns.add(item.getWordHun());
        }
        if (huns.contains(hun)){
            System.out.println("Van már ilyen item");
        }else{
            this.translations.add(new DictionaryItem(hun, eng));
        }
    }

    public void addTranslations (String hun, String eng) {
        for (DictionaryItem item : translations){
            if (item.getWordHun().equals(hun) && !item.getEnglish().contains(eng)){
                item.addToEnglish(eng);
                System.out.println("angol fordítás hozzáadva");
                break;
            }
        }
    }

    public List<String> findTranslations(String hun){
        DictionaryItem itemOut = null;
        for (DictionaryItem item : translations) {
            if ( item.getWordHun().equals(hun)){
                itemOut = item;
                break;
            }else{
                itemOut = new DictionaryItem(" ", Arrays.asList("Nincs ilyen szó"));
            }
        }
        return itemOut.getEnglish();
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("kutya", Arrays.asList("pooch", "dog"));
        System.out.println("kutya1"+ dictionary.findTranslations("kutya"));
// Újra hozzáadnám
        dictionary.addItem("kutya", Arrays.asList("dog"));
        List<String> translations = dictionary.findTranslations("kutya");
        System.out.println("kutya2"+ translations);

        List<String> egggy = new ArrayList<>();
        egggy.add("one");
        dictionary.addItem("egy", egggy);
        System.out.println("egy"+ dictionary.findTranslations("egy"));
// Ha Arrays.asList-tel kreáltam volna, akkor nem lenne bővíthető
        dictionary.addTranslations("egy","a ");
        System.out.println("egy"+ dictionary.findTranslations("egy"));

        System.out.println("nemlétező szó"+ dictionary.findTranslations("nemlétező szó"));

    }
}