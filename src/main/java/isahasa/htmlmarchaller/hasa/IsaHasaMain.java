package isahasa.htmlmarchaller.hasa;
import isahasa.htmlmarchaller.TextSource;

public class IsaHasaMain {

    public static void main(String[] args) {

        A a = new A("  o!o  ");
        TextSource tsa = new A("  tsa  ");
        TextDecorator tdts = new Bold(tsa);

        Bold b = new Bold(a);
        TextDecorator tda = new Bold(a);
        TextDecorator tdb = new Bold(b);
        TextSource tsbbb = new Bold(new Bold(new Bold(a)));

        System.out.println("a     " + a.getPlainText());
        System.out.println("tsa   " + tsa.getPlainText());
        System.out.println("tdts  " + tdts.getPlainText());
        System.out.println("b     " + b.getPlainText());
        System.out.println("tda   " + tda.getPlainText());
        System.out.println("tdb   " + tdb.getPlainText());
        System.out.println("tdbbb " + tsbbb.getPlainText());

    }
}
