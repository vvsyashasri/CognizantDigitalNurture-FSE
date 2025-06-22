package adapter;

public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter() {
        this.stripe = new StripeGateway();
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}
