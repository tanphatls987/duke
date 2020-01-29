import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Storage {
    private Path file;
    public Storage(Path file) {
        this.file = file;
    }

    private void openFile() throws IOException {
        if (!Files.exists(file)) {
            Files.createDirectories(file.getParent());
            Files.createFile(file);
        }
    }

    public ArrayList<Task> loadFile() throws IOException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        TaskFactory taskFactory = new TaskFactory();

        openFile();
        BufferedReader reader = Files.newBufferedReader(file);
        int numberOfTasks = Integer.parseInt(reader.readLine());
        for(int i = 1; i <= numberOfTasks; i++) {
            tasks.add(taskFactory.readTask(reader));
        }
        reader.close();
        return tasks;
    }
    public void storeFile(ArrayList<Task> tasks) throws IOException {
        openFile();
        BufferedWriter writer = Files.newBufferedWriter(file);
        writer.write(String.valueOf(tasks.size()));
        writer.newLine();
        for(Task task : tasks) {
            writer.write(task.getString());
            writer.newLine();
        }
        writer.close();
    }
}
