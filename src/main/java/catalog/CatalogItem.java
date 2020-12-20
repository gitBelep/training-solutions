package catalog;
import java.util.ArrayList;
import java.util.List;

public class CatalogItem {
    private List<Feature> features = new ArrayList<>();
    private final String registrationNumber;
    private final int price;

    public CatalogItem(String registrationNumber, int price, Feature... feature) {
        this.registrationNumber = registrationNumber;
        this.price = price;
        for (Feature f : feature) {
            features.add(f);
        }
    }

    public int fullLengthAtOneItem() {
        int itemLength = 0;
        for (Feature f : features) {
            if (f instanceof AudioFeatures) {
                itemLength += ((AudioFeatures) f).getLength();
            }
        }
        return itemLength;
    }

    public int numberOfPagesAtOneItem() {
        int pages = 0;
        for (Feature f : features) {
            if (f instanceof PrintedFeatures) {
                pages += ((PrintedFeatures) f).getNumberOfPages();
            }
        }
        return pages;
    }

    public List<String> getTitles(){
        List<String> titlesOfOneItem = new ArrayList<>();
        for (Feature f : features) {
            titlesOfOneItem.add(f.getTitle());
        }
        return titlesOfOneItem;
    }

    public List<String> getContributors() {
        List<String> contributorsOfOneItem = new ArrayList<>();
        for (Feature f : features) {
            for (String s : f.getContributors()){
                contributorsOfOneItem.add(s);
            }
// Nem fut le a teszt, ha a a Listnek egyben veszem a toString()-jét, és levágom a []-et,
// mert akkor ez elemek egyben lesznek egy String. E helyett foreach.
//            strLength = f.getContributors().toString().length();
//            contributorsOfOneItem.add(f.getContributors().toString().substring(1, strLength - 1));
        }
        return contributorsOfOneItem;
    }

    public boolean hasAudioFeature() {
        for (Feature f : features) {
            if (f instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature f : features) {
            if (f instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

}
