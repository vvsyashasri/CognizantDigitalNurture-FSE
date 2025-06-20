package Orders;

import java.util.Scanner;

public class OrderSorter {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of orders: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for order " + (i + 1));

            System.out.print("Order ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Total Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            orders[i] = new Order(id, name, price);
        }

        System.out.println("\nSorted using Bubble Sort:");
        Order[] bubbleSorted = orders.clone();
        bubbleSort(bubbleSorted);
        printOrders(bubbleSorted);

        System.out.println("\nSorted using Quick Sort:");
        Order[] quickSorted = orders.clone();
        quickSort(quickSorted, 0, quickSorted.length - 1);
        printOrders(quickSorted);

        scanner.close();
    }
}
