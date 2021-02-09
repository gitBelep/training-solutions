package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Csoportmunka {
    List<Topics> topics = new ArrayList<>();

    // ne páros-páratlan, readAllLines => Buffered olvas-olvas
    public void readFile() {
        Path path = Path.of("src", "main", "resources", "kerdesek.txt");
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String question = "";
            while ((question = br.readLine()) != null) {
                String[] temp = br.readLine().split(" ");
                String topic = temp[2];
                int points = Integer.parseInt(temp[1]);
                int answer = Integer.parseInt(temp[0]);
                topics.add(new Topics(question, topic, points, answer));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file", e);
        }
    }

    public List<String> questionsPerTopics(String topic) {
        List<String> result = new ArrayList<>();
        for (Topics t : topics) {
            if (t.getTopic().equals(topic)) {
                result.add(t.getQuestion());
            }
        }
        return result;
    }

    public Topics getRandomTopic() {
        Random rnd = new Random();
        return topics.get(rnd.nextInt(topics.size()));
    }

    public Map<String, List<Topics>> getGroupedTopics() {
        Map<String, List<Topics>> topicMap = new TreeMap<>();
        for (Topics t : topics) {
            String actualKey = t.getTopic();
            if (!topicMap.containsKey(actualKey)) {
                topicMap.put(actualKey, new ArrayList<>());
            }
            topicMap.get(actualKey).add(t);
        }
        return topicMap;
    }

    public String wichTopicGivesMostPoints() {
        Map<String, List<Topics>> map = getGroupedTopics();
         List<String> result = new ArrayList<>();

        for (String key : map.keySet()) {
            int sumPoints = 0;
            for (Topics t : map.get(key)) {
                sumPoints += t.getPoints();
            }
            result.add(" "+ ((sumPoints < 10) ? "0" : "")+ sumPoints +": "+ key);
        }
        result.sort(Comparator.reverseOrder());
        System.out.println(result);
        return result.get(0);
    }

}
