package inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManager {
    private static Map<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product p) {
        inventory.put(p.getProductId(), p);
        System.out.println("New product has been added.");
    }

    public static void updateProduct(int productId, int newQty, double newPrice) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.setQuantity(newQty);
            p.setPrice(newPrice);
            System.out.println("Product updated.");
        } else {
            System.out.println("Product ID not found. Cannot update.");
        }
    }

    public static void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product has been deleted.");
        } else {
            System.out.println("Product ID not found. Cannot delete.");
        }
    }

    public static void displayInventory() {
        System.out.println("\nSelect the menu:");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Product p = new Product();
                    
                    System.out.print("Enter Product ID: ");
                    p.setProductId(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Enter Product Name: ");
                    p.setProductName(scanner.nextLine());

                    System.out.print("Enter Quantity: ");
                    p.setQuantity(scanner.nextInt());

                    System.out.print("Enter Price: ");
                    p.setPrice(scanner.nextDouble());

                    addProduct(p);
                    break;

//                case 2:
                case 2:
                    System.out.print("Enter Product ID to Update: ");
                    int updateId = scanner.nextInt();

                    if (inventory.containsKey(updateId)) {
                        System.out.print("Enter New Quantity: ");
                        int newQty = scanner.nextInt();

                        System.out.print("Enter New Price: ");
                        double newPrice = scanner.nextDouble();

                        updateProduct(updateId, newQty, newPrice);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;


                case 3:
                    System.out.print("Enter Product ID to Delete: ");
                    int delId = scanner.nextInt();
                    deleteProduct(delId);
                    break;

                case 4:
                    displayInventory();
                    break;

                case 5:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice. Choose between 1 and 5");
            }
        } while (choice != 5);

        scanner.close();
    }
}
