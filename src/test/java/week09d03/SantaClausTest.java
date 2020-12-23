package week09d03;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SantaClausTest {

    @Test
    public void itIsChristmasGoSanta(){
        List<Person> pp = new ArrayList<>();
        pp.add(new Person(1,"Baba"));
        pp.add(new Person(19,"Olga"));
        pp.add(new Person(41,"Dani"));
        pp.add(new Person(100,"Oma"));
        pp.add(new Person(5,"Gázsi"));
        pp.add(new Person(72,"Kató néni"));
        pp.add(new Person(21,"Abadovorzsenkó"));
        pp.add(new Person(25,"Rézi"));
        pp.add(new Person(33,"Álmos"));
        pp.add(new Person(21,"CSaba"));
        pp.add(new Person(175,"Ozzy"));
        pp.add(new Person(81,"NYanyóca"));
        pp.add(new Person(25,"Tíbor"));
        List<Present> rightPresents = List.of(Present.HOUSEKEEPING, Present.ELECTRONIC, Present.DECORATION);
        SantaClaus santa = new SantaClaus(pp);

        santa.getThroughChimneys();

        assertTrue( rightPresents.contains(pp.get(1).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(2).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(3).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(5).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(6).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(7).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(8).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(9).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(10).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(11).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(12).getPresent()) );

        assertTrue( Person.PRESENTS.contains(pp.get(0).getPresent()) );
        assertTrue( Person.PRESENTS.contains(pp.get(4).getPresent()) );
    }

    @Test
    public void itIsChristmasGoSanta2(){
        List<Person> pp = new ArrayList<>();
        pp.add(new Person(1,"Baba"));
        pp.add(new Person(19,"Olga"));
        pp.add(new Person(41,"Dani"));
        pp.add(new Person(100,"Oma"));
        pp.add(new Person(5,"Gázsi"));
        pp.add(new Person(72,"Kató néni"));
        pp.add(new Person(21,"Abadovorzsenkó"));
        pp.add(new Person(25,"Rézi"));
        pp.add(new Person(33,"Álmos"));
        pp.add(new Person(21,"CSaba"));
        pp.add(new Person(175,"Ozzy"));
        pp.add(new Person(81,"NYanyóca"));
        pp.add(new Person(25,"Tíbor"));
        List<Present> rightPresents = List.of(Present.HOUSEKEEPING, Present.ELECTRONIC, Present.DECORATION);
        SantaClaus santa = new SantaClaus(pp);

        santa.getThroughChimneys2();

        assertTrue( rightPresents.contains(pp.get(1).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(2).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(3).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(5).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(6).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(7).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(8).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(9).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(10).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(11).getPresent()) );
        assertTrue( rightPresents.contains(pp.get(12).getPresent()) );

        assertTrue( Person.PRESENTS.contains(pp.get(0).getPresent()) );
        assertTrue( Person.PRESENTS.contains(pp.get(4).getPresent()) );
    }
}
