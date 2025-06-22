package proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("nature_photo.jpg");

        System.out.println("First call:");
        img1.display();  // Loads and displays

        System.out.println("\nSecond call:");
        img1.display();  // Cached display only
    }
}
