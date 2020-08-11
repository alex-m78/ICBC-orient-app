package com.icbc.orient.Bean;


public class StockHold {
    private int count;//持有此股票的基金数量
    private String stockName;//股票名称
    private String symbol;//股票代码
    private int holdScale;//基金持股比例
    private float Compared;//与上季度相比涨跌幅
    private int total;//累计超额收益
    private double totalWorth;//总市值,单位（万）
    private double netAssert;//最新每股净资产
    private double netProfit;//每股净利润
    private double pettm;//最新pe估值数据
    private double pb;//最新市净率
    private double roe;//最新净资产收益率



    public StockHold(){};

//    public StockHold(String stockName,String symbol,int count){
//        this.count=count;
//        this.stockName=stockName;
//        this.symbol=symbol;
//    }
//
//    public StockHold(String symbol,String stockName,int count,int holdScale,float Compared,int total){
//        this.count=count;
//        this.stockName=stockName;
//        this.symbol=symbol;
//        this.Compared=Compared;
//        this.total=total;
//        this.holdScale=holdScale;
//    }





    public int getCount() {
        return count;
    }

    public String getStockName() {
        return stockName;
    }

    public String getSymbol() {
        return symbol;
    }

    public float getCompared() {
        return Compared;
    }

    public int getHoldScale() {
        return holdScale;
    }

    public int getTotal() {
        return total;
    }

    public double getNetAssert() {
        return netAssert;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public double getPb() {
        return pb;
    }

    public double getPettm() {
        return pettm;
    }

    public double getTotalWorth() {
        return totalWorth;
    }

    public double getRoe() {
        return roe;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

//    public void setCompared(float compared) {
//        Compared = compared;
//    }

//    public void setHoldScale(int holdScale) {
//        this.holdScale = holdScale;
//    }

//    public void setTotal(int total) {
//        this.total = total;
//    }

    public void setNetAssert(double netAssert) {
        this.netAssert = netAssert;
    }

//    public void setNetProfit(double netProfit) {
//        this.netProfit = netProfit;
//    }

    public void setPb(double pb) {
        this.pb = pb;
    }

    public void setPettm(double pettm) {
        this.pettm = pettm;
    }

    public void setTotalWorth(double totalWorth) {
        this.totalWorth = totalWorth;
    }

    public void setRoe(double roe) {
        this.roe = roe;
    }

}
