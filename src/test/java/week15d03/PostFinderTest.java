package week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    @Test
    void testFindPostsFor() {
        PostFinder pf = new PostFinder(Arrays.asList(
            new Post("esh", LocalDate.of(2024, 1, 2), "Totya", "Bye"),
            new Post("DD", LocalDate.of(2020, 1, 2), "Ax", "OMG"),
            new Post("esh", LocalDate.of(2020, 9, 2), "Totya", "He?"),
            new Post("esh", LocalDate.of(2020, 9, 4), "Totya", "No way!"),
            new Post("esh", LocalDate.of(2020, 9, 4), "Totya", "No,no!"),
            new Post("DD", LocalDate.of(2020, 9, 3), "Totya", "What?!"),
            new Post("DD", LocalDate.of(2020, 9, 1), "Totya", "Nice!"),
            new Post("DD", LocalDate.of(2024, 1, 2), "Totya", "LOL"),
            new Post("esh", LocalDate.of(2020, 1, 2), "Ax", "Yeah")
                ) );

        List<Post> resultD = pf.findPostsFor("DD");
        List<Post> resultE = pf.findPostsFor("esh");

        assertEquals(3, resultD.size());
        assertEquals(4, resultE.size());
        assertEquals("Ax", resultE.get(0).getTitle());
        assertEquals("Ax", resultD.get(0).getTitle());
        assertEquals("Totya", resultE.get(2).getTitle());
        assertEquals("What?!", resultD.get(2).getContent());

    }
}