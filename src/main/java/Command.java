public abstract class Command {
    public abstract void run(TaskList tasks, Storage storage, UI ui);
    public abstract boolean isExit();
}
