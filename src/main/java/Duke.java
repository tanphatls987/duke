import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Duke {
    private static void printLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }
    private static void byeMessage() {
        ///simple end message
        System.out.println("End program.");
    }

    private static void printTaskList(ArrayList<Task> tasks) {
        ///print out the task list
        System.out.println("Task list");
        for(int i = 0; i < tasks.size(); i++) {
            Task curTask = tasks.get(i);
            System.out.printf("%d. [%s] [%s] %s\n", i + 1,
                    curTask.getType(),
                    curTask.getDoneIcon(),
                    curTask.getDisplayName()
            );
        }
    }
    private static void setTaskDone(ArrayList<Task> tasks, int pos) {
        ///will throw IndexOutOfBound if wrong number specify
        Task selectTask = tasks.get(pos - 1);
        selectTask.setDone(true);
        System.out.printf("Set as done: %s\n", selectTask.getStatus());
    }
    private static void deleteTask(ArrayList<Task> tasks, int pos) {
        Task selectTask = tasks.remove(pos - 1);
        selectTask.setDone(true);
        System.out.printf("Set as done: %s\n", selectTask.getStatus());
    }
    private static void addToDo(ArrayList<Task> tasks, String name) throws Exception {
        if (name.isEmpty()) {
            throw new Exception("Must be a non-empty string");
        }
        Task newTask = new ToDo(name.strip());
        tasks.add(newTask);
        System.out.printf("Add new todo: %s\n", newTask.getDisplayName());
    }
    private static void addDeadline(ArrayList<Task> tasks, String cmd) throws Exception {
        if (cmd.isEmpty()) {
            throw new Exception("Must be a non-empty string");
        }
        String[] token = cmd.split("/");
        if (token.length != 2) {
            throw new Exception("Wrong format. Expect name/time");
        }
        Task newTask = new Deadline(token[0].strip(), token[1].strip());
        tasks.add(newTask);
        System.out.printf("Add deadline: %s\n", newTask.getDisplayName());
    }
    private static void addEvent(ArrayList<Task> tasks, String cmd) throws Exception {
        if (cmd.isEmpty()) {
            throw new Exception("Must be a non-empty string");
        }
        String[] token = cmd.split("/");
        if (token.length != 2) {
            throw new Exception("Wrong format. Expect name/time");
        }
        Task newTask = new Event(token[0].strip(), token[1].strip());
        tasks.add(newTask);
        System.out.printf("Add event: %s\n", newTask.getDisplayName());
    }

    private static void addTask(ArrayList<Task> tasks, String cmd) {
        try {
            if (cmd.startsWith("todo")) {
                cmd = cmd.substring("todo".length()).strip();
                addToDo(tasks, cmd);
            } else if (cmd.startsWith("deadline")) {
                cmd = cmd.substring("deadline".length()).strip();
                addDeadline(tasks, cmd);
            } else if (cmd.startsWith("event")) {
                cmd = cmd.substring("event".length()).strip();
                addEvent(tasks, cmd);
            } else {
                throw new InputMismatchException("Unknown command");
            }
            System.out.printf("There are %d task(s) in the list\n", tasks.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    public static void main(String[] args) {
        printLogo();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<Task>();
        while (true) {
            String cmd = scanner.nextLine();
            if (cmd.equals("bye")) {
                byeMessage();
                return;
            } else if (cmd.equals("list")){
                printTaskList(tasks);
            } else if (cmd.startsWith("done")) {
                int pos = parseInt(cmd.split( " ")[1]);
                try {
                    setTaskDone(tasks, pos);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Not a valid number");
                }
            } else if (cmd.startsWith("erase")) {
                int pos = parseInt(cmd.split(" ")[1]);
                try {
                    deleteTask(tasks, pos);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Not a valid number");
                }
            }else {
                addTask(tasks, cmd);
            }
        }
    }
}