package decorator;

public class NotificationTest {
    public static void main(String[] args) {
        Notifier basicNotifier = new EmailNotifier();

        Notifier smsDecorator = new SMSNotifier(basicNotifier);
        Notifier fullNotifier = new SlackNotifier(smsDecorator);

        fullNotifier.send("System maintenance scheduled at 10 PM.");
    }
}
