package de.zettsystems.broker;

public class Stock {
    private String stockId;
    private String name;
    private int quantity;

    public Stock() {
        this.stockId = "666";
        this.name = "Microsoft";
    }

    public Stock(String stockId, String name, int quantity) {
        this.stockId = stockId;
        this.name = name;
        this.quantity = quantity;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
