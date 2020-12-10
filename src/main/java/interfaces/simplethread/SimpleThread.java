package interfaces.simplethread;
import java.util.ArrayList;
import java.util.List;

public class SimpleThread implements Runnable{
    private List<String> tasks = new ArrayList<>();

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    private boolean nextStep(){
        if (tasks == null || tasks.size() == 0){
            return false;
        }
        System.out.println(tasks.get(tasks.size() - 1));
        tasks.remove(tasks.size()-1);
        return tasks.size() > 0;
    }

    public List<String> getTasks() {
        return tasks;
    }

    @Override
    public void run() {
        boolean b = true;
        while (b){
            b = nextStep();
        }
    }
}
