package adapter;

public class PayPalGateway {
    public void sendPayment(double amountInUSD) {
        System.out.println("Paid $" + amountInUSD + " via PayPal.");
    }
}
