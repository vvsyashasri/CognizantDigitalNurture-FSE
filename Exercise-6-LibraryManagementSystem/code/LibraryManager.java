package library;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryManager {

    public static Book linearSearch(Book[] books, String title, int[] comparisons) {
        for (int i = 0; i < books.length; i++) {
            comparisons[0]++;
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title, int[] comparisons) {
        int low = 0, high = books.length - 1;

        while (low <= high) {
            comparisons[0]++;
            int mid = (low + high) / 2;
            int result = title.compareToIgnoreCase(books[mid].getTitle());

            if (result == 0) return books[mid];
            if (result > 0) low = mid + 1;
            else high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for book " + (i + 1));

            System.out.print("Book ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            books[i] = new Book(id, title, author);
        }

        System.out.print("\nEnter book title to search (Linear): ");
        String searchTitle1 = scanner.nextLine();
        int[] linearCount = {0};
        Book found1 = linearSearch(books, searchTitle1, linearCount);
        System.out.println(found1 != null
                ? "Found (Linear): " + found1 + " | Comparisons: " + linearCount[0]
                : "Not Found (Linear) | Comparisons: " + linearCount[0]);

        Arrays.sort(books, Comparator.comparing(Book::getTitle));

        System.out.print("Enter book title to search (Binary): ");
        String searchTitle2 = scanner.nextLine();
        int[] binaryCount = {0};
        Book found2 = binarySearch(books, searchTitle2, binaryCount);
        System.out.println(found2 != null
                ? "Found (Binary): " + found2 + " | Comparisons: " + binaryCount[0]
                : "Not Found (Binary) | Comparisons: " + binaryCount[0]);

        scanner.close();
    }
}
