import java.io.IOException;

public class CommandBye extends Command{

    @Override
    public void run(TaskList tasks, Storage storage, UI ui) {
        try {
            storage.storeFile(tasks.getTasks());
            ui.showEndMessage();
        } catch (IOException e) {
            ui.displayError(e);
        }
    }
    @Override
    public boolean isExit() {
        return true;
    }
}
