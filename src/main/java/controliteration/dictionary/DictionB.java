
    package controliteration.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

    public class DictionB {

        private List<DictionItemB> dictionaryItems = new ArrayList<>();

        public void addItem(String word, List<String> translations) {
            boolean found = false;
            for (DictionItemB item: dictionaryItems) {
                if (item.getWord().equals(word)) {
                    item.addTranslations(translations);
                    found = true;
                }
            }

            if (!found) {
                dictionaryItems.add(new DictionItemB(word, translations));
            }

        }

        public List<String> findTranslations(String word) {
            for (DictionItemB item: dictionaryItems) {
                if (item.getWord().equals(word)) {
                    return item.getTranslations();
                }
            }
            return new ArrayList<>();
        }

        public static void main(String[] args) {
            DictionB dictionary = new DictionB();
            dictionary.addItem("kutya", Arrays.asList("pooch", "dog"));



            dictionary.addItem("kutya", Arrays.asList("pooch", "dog"));
            dictionary.addItem("kutya", Collections.singletonList("dawg"));
            dictionary.addItem("kutya", Collections.singletonList("dawg"));

            List<String> translations = dictionary.findTranslations("kutya");
            System.out.println(translations);
        }


    }



