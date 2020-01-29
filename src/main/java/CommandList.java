import java.util.ArrayList;

public class CommandList extends Command {
    @Override
    public void run(TaskList tasks, Storage storage, UI ui) {
        ui.showMessage("Current task list");
        for(int i = 0; i < tasks.size(); i++) {
            Task curTask = tasks.get(i);
            String displayString = String.format("%d. [%s] [%s] %s\n",
                i + 1,
                curTask.getType(),
                curTask.getDoneIcon(),
                curTask.getDisplayName()
            );
            ui.showMessage(displayString);
        }
    }
    @Override
    public boolean isExit() {
        return false;
    }
}
