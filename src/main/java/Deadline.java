import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    private LocalDateTime deadlineTime;


    void setDeadlineTime(LocalDateTime deadlineTime) {
        this.deadlineTime = deadlineTime;
    }
    LocalDateTime getDeadlineTime() {
        return this.deadlineTime;
    }
    public Deadline(String name) {
        super(name);
        setDeadlineTime(LocalDateTime.MIN);
    }
    public Deadline(String name, String deadlineTime) {
        super(name);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-M-d H:mm");
        setDeadlineTime(LocalDateTime.parse(deadlineTime, formatter));
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
