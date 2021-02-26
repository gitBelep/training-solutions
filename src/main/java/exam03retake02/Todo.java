package exam03retake02;

public class Todo {
    private String text;
    private State state;
    private int priority;

    public Todo(String text, int priority) {
        if (priority < 1 || 5 < priority){
            throw new IllegalArgumentException("Invalid, "+ priority);
        }
        this.priority = priority;
        this.text = text;
        this.state = State.NON_COMPLETED;
    }

    public void complete(){
        state = State.COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }
}
