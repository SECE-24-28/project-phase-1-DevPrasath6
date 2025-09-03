import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TodoList todoList = new TodoList(100);
        String filename = "tasks.txt";

        todoList.loadFromFile(filename);

        int choice;
        do {
            System.out.println("\n===== TO-DO LIST MANAGER =====");

            System.out.println("1. Add Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Save Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    todoList.addTask(new Task(title, desc, "Pending"));
                    break;

                case 2:
                    todoList.showTasks();
                    break;

                case 3:
                    todoList.showTasks();
                    System.out.print("Enter task number: ");
                    int num = sc.nextInt();
                    todoList.markTaskCompletedByNumber(num);
                    break;

                case 4:
                    todoList.saveToFile(filename);
                    break;

                case 5:
                    todoList.saveToFile(filename);
                    System.out.println("Exiting... Tasks saved.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

    }
}
