package week15d02;

public class Topics {
    private final String question;
    private final String topic;
    private final int points;
    private final int answer;

    public Topics(String question, String topic, int points, int answer) {
        this.answer = answer;
        this.points = points;
        this.topic = topic;
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public int getPoints() {
        return points;
    }

    public String getTopic() {
        return topic;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return question +" "+topic +" "+ points +" "+ answer;
    }

}
