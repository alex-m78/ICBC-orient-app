package com.icbc.orient.Bean;

import java.util.List;

public class StockPrice {
    private String stockName;
    private List<Double> stockValue;

    public StockPrice(String stockName, List<Double> stockValue) {
        this.stockName = stockName;
        this.stockValue = stockValue;
    }

    public StockPrice() {
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public List<Double> getStockValue() {
        return stockValue;
    }

    public void setStockValue(List<Double> stockValue) {
        this.stockValue = stockValue;
    }
}
