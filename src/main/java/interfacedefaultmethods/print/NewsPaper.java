package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable{
    private List<String> newspaper;

    public NewsPaper() {
        this.newspaper = new ArrayList<>();
    }

    public void addPage(String page){
        newspaper.add(page);
    }

    @Override
    public int getLength() {
        return newspaper.size();
    }

    @Override
    public String getPage(int p) {
        return newspaper.get(p);
    }

}
