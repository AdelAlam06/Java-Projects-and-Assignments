import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        ToDoList list = new ToDoList();

        list.addTask(new Task("Grocery", 60, -2));
        list.addTask(new Task("Garbage", 50, 3));
        list.addTask(new Task("Pick up", 10, 1));

        System.out.println(list.getTask());
    }
}
