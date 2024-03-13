import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben Sie die risikofreie Rendite ein:");
        double riskFreeRate = scanner.nextDouble();

        System.out.println("Geben Sie die erwartete Marktrendite ein:");
        double expectedMarketReturn = scanner.nextDouble();

        System.out.println("Geben Sie die Varianz der Marktrendite ein:");
        double marketVariance = scanner.nextDouble();

        CAPM capm = new CAPM(riskFreeRate, expectedMarketReturn, marketVariance);
        Portfolio portfolio = new Portfolio(capm);

        while (true) {
            System.out.println("Geben Sie den Namen der Aktie ein (oder 'fertig' zum Beenden):");
            String name = scanner.next();
            if ("fertig".equalsIgnoreCase(name)) {
                break;
            }

            System.out.println("Geben Sie die Anzahl der Aktien im Portfolio ein:");
            int quantity = scanner.nextInt();

            System.out.println("Geben Sie den aktuellen Marktpreis der Aktie ein:");
            double marketPrice = scanner.nextDouble();

            System.out.println("Geben Sie die Kovarianz zwischen der Aktienrendite und der Marktrendite ein:");
            double covarianceWithMarket = scanner.nextDouble();

            Stock stock = new Stock(name, quantity, marketPrice, covarianceWithMarket);
            portfolio.addStock(stock);
        }

        // Übersicht über jede Aktie
        for (Stock stock : portfolio.getStocks()) {
            double stockExpectedReturn = capm.calculateExpectedReturn(stock.getCovarianceWithMarket());
            double stockBeta = capm.calculateBeta(stock.getCovarianceWithMarket());
            System.out.println(stock.getName() + ": \nErwartete Rendite: " + String.format("%.2f", stockExpectedReturn * 100) + "%, Beta: " + String.format("%.2f", stockBeta));
        }

        // Gesamtportfolio-Übersicht
        double portfolioReturn = portfolio.calculatePortfolioReturn();
        double portfolioBeta = portfolio.calculatePortfolioBeta();
        System.out.println("Gesamtportfolio: \nErwartete Rendite: " + String.format("%.2f", portfolioReturn * 100) + "%, Beta: " + String.format("%.2f", portfolioBeta));

        scanner.close();
    }
}