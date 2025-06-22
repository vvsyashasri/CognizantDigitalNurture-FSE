package adapter;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter() {
        this.paypal = new PayPalGateway();
    }

    @Override
    public void processPayment(double amount) {
        paypal.sendPayment(amount);
    }
}
