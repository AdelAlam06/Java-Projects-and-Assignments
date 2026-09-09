import java.util.PriorityQueue;

public class Task implements Comparable<Task> {
    
    private int length = 0;
    private int priority = 0;
    private String task = "";

    public Task(String task, int length, int priority){
        this.length = length;
        this.priority = priority;
        this.task = task;
    }

    @Override
    public int compareTo(Task other) {
        
        return other.priority - this.priority;
    }

    @Override
    public String toString() {
        return "Task: " + task + ", Length of Task: " + length + "minutes, Priority: " + priority;
    }
}
