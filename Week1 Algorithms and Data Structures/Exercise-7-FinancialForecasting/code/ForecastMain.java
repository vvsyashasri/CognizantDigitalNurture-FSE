package finance;

import java.util.Scanner;

public class ForecastMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (as percentage, e.g., 5 for 5%): ");
        double growthRateInput = scanner.nextDouble();
        double growthRate = growthRateInput / 100;  // Convert to decimal

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        double futureValue = ForecastCalculator.calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Predicted future value after %d years: ₹%.2f\n", years, futureValue);

        scanner.close();
    }
}
