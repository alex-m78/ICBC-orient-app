package com.icbc.orient.Bean;

public class Target {
    private String StockType;
    private String IndexType;
    private String mean;
    private String SD;
    private String validSample;
    private int id;

    public int getId() {
        return id;
    }

    public String getIndexType() {
        return IndexType;
    }

    public String getMean() {
        return mean;
    }

    public String getSD() {
        return SD;
    }

    public String getStockType() {
        return StockType;
    }

    public String getValidSample() {
        return validSample;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIndexType(String indexType) {
        IndexType = indexType;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public void setStockType(String stockType) {
        StockType = stockType;
    }

    public void setValidSample(String validSample) {
        this.validSample = validSample;
    }
}
