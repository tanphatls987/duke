
import java.io.BufferedReader;
import java.io.IOException;

public class Event extends Task{
    private String time;
    public Event(String name, String time) {
        super(name);
        this.time = time;
    }
    public String getTime() {
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

    @Override
    public String getString() {
        return "{\n" +
                "Event\n" +
                getName() + "\n" +
                getTime() + "\n" +
                "}";
    }
    public static Event readBuffer(BufferedReader reader) throws IOException {
        String eventName = reader.readLine();
        String eventTime = reader.readLine();
        return new Event(eventName, eventTime);
    }
}
