
import java.io.BufferedReader;
import java.io.IOException;
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


    private DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yy-M-d H:mm");
    }
    @Override
    public String getString() {
        DateTimeFormatter formatter = getDateTimeFormatter();
        return "{\n" +
                "Deadline" + "\n" +
                getName() + "\n" +
                getDeadlineTime().format(formatter) + "\n" +
                "}";
    }

    public static Deadline readBuffer(BufferedReader reader) throws IOException{
        String deadlineName = reader.readLine();
        String deadlineTime = reader.readLine();
        return new Deadline(deadlineName, deadlineTime);
    }
}
