package Employee;


import java.util.Scanner;

public class EmployeeManager {
    private static Employee[] employees = new Employee[100];
    private static int count = 0;

    public static void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee list is full.");
        }
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) {
                System.out.println("Employee found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void displayEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("\n-----------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-10s |\n", "Emp ID", "Name", "Position", "Salary");
        System.out.println("-----------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            Employee emp = employees[i];
            System.out.printf("| %-10d | %-20s | %-15s | ₹%-9.2f |\n",
                    emp.getEmployeeId(), emp.getName(), emp.getPosition(), emp.getSalary());
        }

        System.out.println("-----------------------------------------------------------------------------------");
    }


    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Position: ");
                    String position = scanner.nextLine();

                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();

                    Employee e = new Employee(id, name, position, salary);
                    addEmployee(e);
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();
                    searchEmployee(searchId);
                    break;

                case 3:
                    displayEmployees();
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = scanner.nextInt();
                    deleteEmployee(delId);
                    break;

                case 5:
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
