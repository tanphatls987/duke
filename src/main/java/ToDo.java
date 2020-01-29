
import java.io.BufferedReader;
import java.io.IOException;

public class ToDo extends Task{
    public ToDo(String name) {
        super(name);
    }
    @Override
    public String getDisplayName() {
        return getName();
    }
    @Override
    public String getType() {
        return "T";
    }
    public String getString() {
        return "{\n" +
                "ToDo\n" +
                getName() + "\n" +
                "}";
    }

    public static ToDo readBuffer(BufferedReader reader) throws IOException {
        return new ToDo(reader.readLine());
    }
}
