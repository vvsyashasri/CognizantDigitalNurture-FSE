package observer;

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket tcsStock = new StockMarket("TCS");

        Observer user1 = new MobileApp("Yashasri");
        Observer user2 = new WebApp("investor@example.com");

        tcsStock.registerObserver(user1);
        tcsStock.registerObserver(user2);

        tcsStock.setPrice(3675.50);  // All observers notified

        tcsStock.removeObserver(user2);

        tcsStock.setPrice(3690.00);  // Only MobileApp gets notified
    }
}
