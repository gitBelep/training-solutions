package interfacedefaultmethods.print;

public class Printer {

    public String print(NewsPaper np) {
        StringBuilder sb = new StringBuilder("");
        if (np.getLength() > 0) {
            for (int i = 0; i < np.getLength(); i++) {
                sb.append(np.getPage(i) + "\n");
            }
        }
        return sb.toString();
    }
//"Page1\n[#ff0000]Page2\n"
    public String print(StoryBook story) {
        StringBuilder sb = new StringBuilder("");
        if (story.getLength() > 0) {
            for (int i = 0; i < story.getLength(); i++) {
                if (!Printable.BLACK.equals(story.getColor(i))){
                    sb.append("[" + story.getColor(i) + "]");
                }
                sb.append(story.getPage(i) + "\n");
            }
        }
        return sb.toString();
    }
}
