package exam03retake02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public int getNumberOfItemsLeft(){
        int counter = 0;
        for (Todo t : todos){
            if (t.getState() == State.NON_COMPLETED){
                counter++;
            }
        }
        return counter;
    }

    public List<String> getMostImportantTodosText(){
        todos.sort((t1, t2) -> t1.getPriority() - t2.getPriority());
        List<String> result = new ArrayList<>();
        result.add(todos.get(0).getText());
        for (int i = 1; i < todos.size(); i++){
            if(todos.get(i).getPriority() == todos.get(0).getPriority()){
                result.add(todos.get(i).getText());
            } else {
                break;
            }
        }
        return result;
    }

    public void deleteCompleted(){
        Iterator<Todo> t = todos.iterator();
        while (t.hasNext()){
            Todo todo = t.next();
            if(todo.getState() == State.COMPLETED){
                t.remove();
            }
        }
    }

    public void addTodo(Todo todo){
        todos.add(todo);
    }

    public List<Todo> getTodos(){
        return new ArrayList<>(todos);
    }

}
