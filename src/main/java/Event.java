import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    private LocalDateTime time;
    public Event(String name, String time) {
        super(name);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-M-d H:mm");
        this.time = LocalDateTime.parse(time, formatter);
    }
    public LocalDateTime getTime() {
        return this.time;
    }
    @Override
    public String getDisplayName() {

        return getName() + "(at: " + time + ")";
    }
    @Override
    public String getType() {

        return "E";
    }

}
