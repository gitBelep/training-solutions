package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable{
    private List<ColoredPage> storyBook;

    public StoryBook() {
        storyBook = new ArrayList<>();
    }

    public void addPage(String page, String color){
        storyBook.add(new ColoredPage(page, color));
    }

    @Override
    public int getLength() {
        return storyBook.size();
    }

    @Override
    public String getPage(int p) {
        return storyBook.get(p).getContetnt();
    }

    @Override
    public String getColor(int p) {
        return storyBook.get(p).getColor();
    }
}
