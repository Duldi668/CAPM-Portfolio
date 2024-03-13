import java.util.ArrayList; //Seite 466 führt arraylist ein und Seite 1000

public class Portfolio {
    private ArrayList<Stock> stocks;
    private CAPM capm;

    public Portfolio(CAPM capm) {
        this.stocks = new ArrayList<>();
        this.capm = capm;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    // Berechnet die Portfoliorendite basierend auf dem CAPM
    public double calculatePortfolioReturn() {
        double totalValue = 0;
        double weightedReturnSum = 0;
        for (Stock stock : stocks) {
            double stockValue = stock.getMarketPrice() * stock.getQuantity();
            totalValue += stockValue;
            double expectedReturn = capm.calculateExpectedReturn(stock.getCovarianceWithMarket());
            weightedReturnSum += stockValue * expectedReturn;
        }
        return totalValue > 0 ? weightedReturnSum / totalValue : 0;
    }

    // Berechnet das Beta des Gesamtportfolios
    public double calculatePortfolioBeta() {
        double totalValue = 0;
        double weightedBetaSum = 0;
        for (Stock stock : stocks) {
            double stockValue = stock.getMarketPrice() * stock.getQuantity();
            totalValue += stockValue;
            double stockBeta = capm.calculateBeta(stock.getCovarianceWithMarket());
            weightedBetaSum += stockValue * stockBeta;
        }
        return totalValue > 0 ? weightedBetaSum / totalValue : 0;
    }

    // Getter für die Aktienliste, falls benötigt
    public ArrayList<Stock> getStocks() {
        return stocks;
    }
}

