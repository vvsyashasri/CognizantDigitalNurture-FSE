package Search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SearchFunction {

    public static Product linearSearch(Product[] products, String name, int[] comparisons) {
        for (int i = 0; i < products.length; i++) {
            comparisons[0]++;
            if (products[i].getProductName().equalsIgnoreCase(name)) {
                return products[i];
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name, int[] comparisons) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            comparisons[0]++;
            int mid = (low + high) / 2;
            int result = name.compareToIgnoreCase(products[mid].getProductName());

            if (result == 0) return products[mid];
            if (result > 0) low = mid + 1;
            else high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for product " + (i + 1));

            System.out.print("Product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Category: ");
            String category = scanner.nextLine();

            products[i] = new Product(id, name, category);
        }

        System.out.print("Enter product name to search (Linear): ");
        String searchLinear = scanner.nextLine();
        int[] linearComparisons = {0};
        Product found1 = linearSearch(products, searchLinear, linearComparisons);
        System.out.println(found1 != null
                ? "Found (Linear): " + found1 + " | Comparisons: " + linearComparisons[0]
                : "Not Found (Linear) | Comparisons: " + linearComparisons[0]);

        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        System.out.print("Enter product name to search (Binary): ");
        String searchBinary = scanner.nextLine();
        int[] binaryComparisons = {0};
        Product found2 = binarySearch(products, searchBinary, binaryComparisons);
        System.out.println(found2 != null
                ? "Found (Binary): " + found2 + " | Comparisons: " + binaryComparisons[0]
                : "Not Found (Binary) | Comparisons: " + binaryComparisons[0]);

        scanner.close();
    }
}
