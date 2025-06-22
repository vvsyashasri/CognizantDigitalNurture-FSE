package adapter;

public class StripeGateway {
    public void makePayment(double value) {
        System.out.println("Charged $" + value + " via Stripe.");
    }
}
