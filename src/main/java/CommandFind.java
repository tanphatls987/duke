import java.util.ArrayList;
import java.util.stream.Collectors;

public class CommandFind extends Command {
    private String pattern;

    public CommandFind(String pattern) {
        this.pattern = pattern;
    }

    private boolean isTaskMatch(Task task) {
        String taskName = task.getName();
        return taskName.contains(pattern);
    }
    @Override
    public void run(TaskList tasks, Storage storage, UI ui) {
        ui.showMessage("Matching tasks:");
        ArrayList<Task> matchTasks = new ArrayList<Task>();
        for (Task task : tasks.getTasks()) {
            if (isTaskMatch(task)) {
                matchTasks.add(task);
            }
        }

        for (int i = 0; i < matchTasks.size(); i++) {
            ui.showMessage(String.format("%d. %s",
                    i + 1,
                    matchTasks.get(i).getDisplayName())
            );
        }
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
