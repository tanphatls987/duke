import java.time.LocalDateTime;

public class CommandAddDeadline extends Command {
    private String deadlineName;
    private LocalDateTime deadlineTime;

    public CommandAddDeadline(String deadlineName, LocalDateTime deadlineTime) {
        this.deadlineName = deadlineName;
        this.deadlineTime = deadlineTime;
    }


    @Override
    public void run(TaskList tasks, Storage storage, UI ui) {
        Deadline newDeadline = new Deadline(deadlineName, deadlineTime);
        String message = "Add new deadline: " + newDeadline.getName() + " at " + newDeadline.getTime();
        ui.showMessage(message);

        tasks.add(newDeadline);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
