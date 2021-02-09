package week15d02;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class CsoportmunkaTest {

    @Test
    void questionsPerTopics() {
        Csoportmunka c = new Csoportmunka();
        c.readFile();
        //57 db
        assertEquals(18, c.questionsPerTopics("foldrajz").size());
        assertEquals(2, c.questionsPerTopics("kemia").size());
        assertEquals(1, c.questionsPerTopics("magyar").size());
        assertEquals(21, c.questionsPerTopics("matematika").size());
        assertEquals(15, c.questionsPerTopics("tortenelem").size());
    }

    @Test
    void getRandomTopic() {
        Csoportmunka c = new Csoportmunka();
        c.readFile();

        Topics topic = c.getRandomTopic();

        assertTrue(topic.getTopic().length() > 2);
    }

    @Test
    void getGroupedTopics() {
        Csoportmunka c = new Csoportmunka();
        c.readFile();

        Map<String, List<Topics>> tops = c.getGroupedTopics();

        assertEquals(5, tops.size());
    }

    @Test
    void wichTopicGivesMostPoints() {
        Csoportmunka c = new Csoportmunka();
        c.readFile();

        // 43: matematika,  40: foldrajz,  28: tortenelem,  03: magyar,  03: kemia]
        assertEquals(" 43: matematika", c.wichTopicGivesMostPoints());
    }
}