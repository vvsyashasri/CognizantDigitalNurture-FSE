package adapter;

import java.util.Scanner;

public class PaymentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose payment gateway: PayPal / Stripe");
        String choice = scanner.nextLine().toLowerCase();

        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();

        PaymentProcessor processor;

        if (choice.equals("paypal")) {
            processor = new PayPalAdapter();
        } else if (choice.equals("stripe")) {
            processor = new StripeAdapter();
        } else {
            System.out.println("Invalid gateway.");
            scanner.close();
            return;
        }

        processor.processPayment(amount);
        scanner.close();
    }
}
