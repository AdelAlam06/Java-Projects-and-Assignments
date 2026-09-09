import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ToDoList {
    PriorityQueue<Task> items;

    public ToDoList(){
        items = new PriorityQueue<Task>();
    }

    public void addTask(Task t){
        items.add(t);
    }
    public String getTask(){
        Task t = items.remove();
        return t.toString();
    }
}
