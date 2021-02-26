package exam03retake02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public int getNumberOfItemsLeft(){

    }

    public List<Todo> getMostImportantTodosText(){

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

}
