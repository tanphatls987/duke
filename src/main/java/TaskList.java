import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void erase(int position) {
        tasks.remove(position);
    }

    public void clear() {
        tasks.clear();
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int position) {
        return tasks.get(position);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
