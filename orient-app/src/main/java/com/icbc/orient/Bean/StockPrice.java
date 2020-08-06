package com.icbc.orient.Bean;

import java.util.List;

public class StockPrice {
    private String stockCode;
    private String stockName;
    private String tradeDate;
    private double close;

    public void setClose(double close) {
        this.close = close;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public double getClose() {
        return close;
    }

    public String getStockCode() {
        return stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public String getTradeDate() {
        return tradeDate;
    }
}
