package catalog;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catI){
        catalogItems.add(catI);
    }

    public void deleteItemByRegistrationNumber(String regNr){
        for (int i = 0; i < catalogItems.size(); i++) {
            if (catalogItems.get(i).getRegistrationNumber().equals(regNr)){
                catalogItems.remove(i);
                return;
            }
        }
    }

    public double averagePageNumberOver(int minPages){
        if (minPages <= 0){
            throw new IllegalArgumentException("Page number must be positive");
        }
        double average = 0.0, j = 0.0;
        int numberOfPages = 0;
        for (CatalogItem catalogItem : catalogItems) {
            numberOfPages = catalogItem.numberOfPagesAtOneItem();
            if (numberOfPages > minPages) {
                average += numberOfPages;
                j++;
            }
        }
        if (average < 1){
            throw new IllegalArgumentException("No page");
        }
        return average / j;
    }

    public int getAllPageNumber(){
        int numberOfPages = 0;
        for (CatalogItem c : catalogItems)  {
                numberOfPages += c.numberOfPagesAtOneItem();
            }
        return numberOfPages;
    }

    public int getFullLength(){
        int fullLength = 0;
        for (CatalogItem c : catalogItems) {
            fullLength += c.fullLengthAtOneItem();
        }
        return fullLength;
    }

    public List<CatalogItem> getAudioLibraryItems(){
        List<CatalogItem> audioItems = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            if (c.hasAudioFeature()){
                audioItems.add(c);
            }
        }
        return audioItems;
    }

    public List<CatalogItem> getPrintedLibraryItems(){
        List<CatalogItem> printedItems = new ArrayList<>();
        for (CatalogItem c : catalogItems){
            if (c.hasPrintedFeature()){
                printedItems.add(c);
            }
        }
        return printedItems;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria criteria){
        if (!criteria.hasContributor()) {
            return findByTitleCriteria(criteria);
        }
        if (!criteria.hasTitle()) {
            return findByContributorCriteria(criteria);
        }
        return findByBothCriteria(criteria);
    }

    private List<CatalogItem> findByTitleCriteria(SearchCriteria criteria) {
        List<CatalogItem> foundItems = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            for (String s : c.getTitles()) {
                if ( s.equals(criteria.getTitle()) ){
                    foundItems.add(c);
                }
            }
        }
        return foundItems;
    }

    private List<CatalogItem> findByContributorCriteria(SearchCriteria criteria) {
        List<CatalogItem> foundItems = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            for (String s : c.getContributors()) {
                if ( s.equals(criteria.getContributor()) ){
                    foundItems.add(c);
                }
            }
        }
        return foundItems;
    }

    private List<CatalogItem> findByBothCriteria(SearchCriteria criteria) {
        List<CatalogItem> foundItems = new ArrayList<>();
        for (CatalogItem c : catalogItems) {
            for (String s : c.getContributors()) {
                if ( s.equals(criteria.getContributor()) && c.getTitles().contains(criteria.getTitle()) ){
                    foundItems.add(c);
                }
            }
        }
        return foundItems;
    }

}
