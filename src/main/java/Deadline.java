public class Deadline extends Task{
    private String deadlineTime;


    void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime;
    }
    String getDeadlineTime() {
        return this.deadlineTime;
    }
    public Deadline(String name) {
        super(name);
        setDeadlineTime("unknown");
    }
    public Deadline(String name, String deadlineTime) {
        super(name);
        setDeadlineTime(deadlineTime);
    }

    @Override
    public String getDisplayName() {
        return getName() + "(by: " + getDeadlineTime() + ")";
    }
    @Override
    public String getType() {
        return "D";
    }
}
