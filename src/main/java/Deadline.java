
import java.io.BufferedReader;
import java.io.IOException;

public class Deadline extends Task{
    private String deadlineTime;

    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime;
    }
    public String getDeadlineTime() {
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


    @Override
    public String getString() {
        return "{\n" +
                "Deadline" + "\n" +
                getName() + "\n" +
                getDeadlineTime() + "\n" +
                "}";
    }

    public static Deadline readBuffer(BufferedReader reader) throws IOException{
        String deadlineName = reader.readLine();
        String deadlineTime = reader.readLine();
        return new Deadline(deadlineName, deadlineTime);
    }
}
