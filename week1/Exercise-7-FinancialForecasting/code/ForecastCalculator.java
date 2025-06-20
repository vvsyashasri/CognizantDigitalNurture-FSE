package finance;

public class ForecastCalculator {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }
}
