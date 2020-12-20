package catalog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AudioFeatures implements Feature{
    private final List<String> composer = new ArrayList<>();
    private final List<String> performers = new ArrayList<>();
    private String title;
    private int length;

    public AudioFeatures(String title, int length, List<String> performers) {
        checkDatas(title, length, performers);
        this.title = title;
        this.length = length;
        this.performers.addAll(performers);
    }

    public AudioFeatures(String title, int length, List<String> composer, List<String> performers) {
        checkDatas(title, length, performers);
        this.title = title;
        this.length = length;
        this.performers.addAll(performers);
        if (Validators.isEmpty(composer)){
            throw new IllegalArgumentException("Invalid composer");
        }
        this.composer.addAll(composer);
    }

    private void checkDatas(String title, int length, List<String> performers){
        if ( Validators.isBlank(title) ) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length <= 0){
            throw new IllegalArgumentException("Invalid length");
        }
        if ( Validators.isEmpty(performers) ) {
            throw new IllegalArgumentException("Invalid performer");
        }
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (String s : performers) {
            contributors.add(s);
        }
        for (String s : composer) {
            contributors.add(s);
        }
        return contributors;
    }

// Arra gyanakodtam, ez okozza a CatalogItem ellenőrzésekor a hibát
//    @Override
//    public List<String> getContributors() {
//        List<String> contributors = new ArrayList<>();
//        contributors.addAll(performers);
//        contributors.addAll(composer);
//        return contributors;
//    }

    @Override
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
}
