package isahasa.htmlmarchaller.hasa;
import isahasa.htmlmarchaller.TextSource;

public class A implements TextSource {
    private String a;

    public A(String a) {
        this.a = a;
    }

    @Override
    public String getPlainText() {
        return a;
    }
}
