public class CAPM {
    private double riskFreeRate;
    private double expectedMarketReturn;
    private double marketVariance;

    public CAPM(double riskFreeRate, double expectedMarketReturn, double marketVariance) {
        this.riskFreeRate = riskFreeRate;
        this.expectedMarketReturn = expectedMarketReturn;
        this.marketVariance = marketVariance;
    }

    // Methode zur Berechnung des Beta einer Aktie
    public double calculateBeta(double covarianceWithMarket) {
        return covarianceWithMarket / marketVariance;
    }

    // Methode zur Berechnung der erwarteten Rendite einer Aktie
    public double calculateExpectedReturn(double covarianceWithMarket) {
        double beta = calculateBeta(covarianceWithMarket);
        return riskFreeRate + beta * (expectedMarketReturn - riskFreeRate);
    }
}

// Ab Seite 197 werden Methoden beschrieben