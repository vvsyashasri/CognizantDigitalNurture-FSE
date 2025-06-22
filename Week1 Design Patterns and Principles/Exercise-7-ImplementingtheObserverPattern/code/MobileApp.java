package observer;

public class MobileApp implements Observer {
    private String username;

    public MobileApp(String username) {
        this.username = username;
    }

    public void update(String stockName, double newPrice) {
        System.out.println("MobileApp - " + username + ": " + stockName + " updated to ₹" + newPrice);
    }
}
