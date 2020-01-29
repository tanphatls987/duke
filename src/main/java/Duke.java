import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Duke {
    private UI ui;
    private TaskList tasks;
    private Storage storage;

    public Duke() {
        ui = new UI();
        tasks = new TaskList();


        String currentDirectory = System.getProperty("user.dir");
        Path file = Paths.get(currentDirectory, "data", "tasks.txt");
        storage = new Storage(file);

        try {
            tasks = new TaskList(storage.loadFile());
        } catch (Exception e) {
            ui.showMessage(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showLogo();
        boolean isExit = false;

        Parser parser = new Parser();
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = parser.parse(fullCommand);
                c.run(tasks, storage, ui);
                isExit = c.isExit();
            } catch (Exception e) {
                ui.showMessage(e.getMessage());
            }
        }
        try {
            storage.storeFile(tasks.getTasks());
        } catch (IOException e) {
            System.out.println("Error");
            ui.showMessage(e.getMessage());
        }
    }
    public static void main(String[] args) {
        new Duke().run();
    }
}