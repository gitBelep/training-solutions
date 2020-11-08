package arraylist;
import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> title = new ArrayList<>();

    public void add(String tit){
        title.add(tit);
    }

    List<String> foundBooks = new ArrayList<>();
    public List<String> findAllByPrefix(String prefix){
        foundBooks.clear();
        for (int i = 0; i < title.size(); i++) {
            if (title.get(i).substring(0,prefix.length()).equals(prefix)){
                foundBooks.add(title.get(i));
            }
        }
        return foundBooks;
    }

    public List<String> getTitles(){
        return title;
    }

    public static void main(String[] args) {
        Books b = new Books();
        b.add("Pillantás");
        b.add("Egri");
        b.add("Pillangóhatás");
        System.out.println(b.findAllByPrefix("Pill"));
        System.out.println(b.getTitles());
    }
}
