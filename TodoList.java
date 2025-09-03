
import java.io.*;
import java.util.Scanner;

public class TodoList {

    private Task[] tasks;
    private int count;

    public TodoList(int size) {
        tasks = new Task[size];
        count = 0;
    }

    public void addTask(Task task) {
        if (count < tasks.length) {
            tasks[count++] = task;
            System.out.println("Task added.");
        } else {
            System.out.println("Task list is full!");
        }
    }

    public void showTasks() {
        if (count == 0) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }

    public void markTaskCompletedByNumber(int num) {
        if (num < 1 || num > count) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks[num - 1].markCompleted();
        System.out.println("Task #" + num + " marked as completed.");
    }

    public void saveToFile(String filename) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(filename));
            for (int i = 0; i < count; i++) {
                pw.println(tasks[i].toFileString());
            }
            System.out.println("Tasks saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public void loadFromFile(String filename) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
            count = 0;
            while (sc.hasNextLine() && count < tasks.length) {
                String line = sc.nextLine();
                Task task = Task.fromFileString(line);
                if (task != null) {
                    tasks[count++] = task;
                }
            }
            System.out.println("Tasks loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
