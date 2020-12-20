package catalog;

public class SearchCriteria {
    private String contributor;
    private String title;

    private SearchCriteria(String contributor, String title){
        this.contributor = contributor;
        this.title = title;
    }

    public static SearchCriteria createByTitle(String title){
        exIfNull(title);
        return new SearchCriteria("", title);
    }

    public static SearchCriteria createByContributor(String contributor){
        exIfNull(contributor);
        return new SearchCriteria(contributor, "");
    }

    public static SearchCriteria createByBoth(String title, String contributor){
        exIfNull(title);
        exIfNull(contributor);
        return new SearchCriteria(contributor, title);
    }

    public boolean hasTitle(){
        return ( !"".equals(title.trim()) );
    }

    public boolean hasContributor() {
        return ( !"".equals(contributor.trim()) );
    }

    public String getContributor() {
        return contributor;
    }
    public String getTitle() {
        return title;
    }

    private static void exIfNull(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String is null");
        }
    }
}
