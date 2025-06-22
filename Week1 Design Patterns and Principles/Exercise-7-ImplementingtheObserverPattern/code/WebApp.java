package observer;

public class WebApp implements Observer {
    private String email;

    public WebApp(String email) {
        this.email = email;
    }

    public void update(String stockName, double newPrice) {
        System.out.println("WebApp - " + email + ": " + stockName + " updated to ₹" + newPrice);
    }
}
