public abstract class Command {
    /**
     * Run the command on console
     * @param tasks Task list
     * @param storage Handle file storage
     * @param ui Show interaction
     */
    public abstract void run(TaskList tasks, Storage storage, UI ui);

    /**
     *
     * @return true if it is an end command
     */
    public abstract boolean isExit();
}
