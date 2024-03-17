public class CAPM {
    private double riskFreeRate;
    private double expectedMarketReturn;
    private double marketVariance;

    public CAPM(double riskFreeRate, double expectedMarketReturn, double marketVariance) {
        this.riskFreeRate = riskFreeRate;
        this.expectedMarketReturn = expectedMarketReturn;
        this.marketVariance = marketVariance;
    }

    public double calculateBeta(double covarianceWithMarket) {
        return covarianceWithMarket / marketVariance;
    }

    public double calculateExpectedReturn(double covarianceWithMarket) {
        double beta = calculateBeta(covarianceWithMarket);
        return riskFreeRate + beta * (expectedMarketReturn - riskFreeRate);
    }
}