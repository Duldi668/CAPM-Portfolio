public class Stock {
    private String name;
    private int quantity;
    private double marketPrice; 
    private double covarianceWithMarket;

    public Stock(String name, int quantity, double marketPrice, double covarianceWithMarket) {
        this.name = name;
        this.quantity = quantity;
        this.marketPrice = marketPrice;
        this.covarianceWithMarket = covarianceWithMarket;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public double getCovarianceWithMarket() {
        return covarianceWithMarket;
    }
}