package Tasks;

import java.util.Scanner;

public class TaskManager {
    private static TaskNode head = null;

    public static void addTask(Tasks task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task added.");
    }

    public static void searchTask(int id) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == id) {
                System.out.println("Task found: " + current.task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public static void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("| %-8s | %-20s | %-10s |\n", "Task ID", "Task Name", "Status");
        System.out.println("-------------------------------------------------------------");

        TaskNode temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }

        System.out.println("-------------------------------------------------------------");
    }

    public static void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.task.getTaskId() == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        TaskNode current = head;
        TaskNode prev = null;

        while (current != null && current.task.getTaskId() != id) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task not found.");
        } else {
            prev.next = current.next;
            System.out.println("Task deleted.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Task Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Status: ");
                    String status = scanner.nextLine();

                    Tasks task = new Tasks(id, name, status);
                    addTask(task);
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    searchTask(searchId);
                    break;

                case 3:
                    displayTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    deleteTask(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
