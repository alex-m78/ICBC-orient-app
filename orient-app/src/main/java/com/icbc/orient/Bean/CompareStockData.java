package com.icbc.orient.Bean;

/**对比重仓股名称，用于第二页第三项显示
 * @author hkd
 * @date 2020/7/25 - 10:34
 */
public class CompareStockData {
    private String predictStock;
    private String realStock;

    public String getPredictStock() {
        return predictStock;
    }

    public void setPredictStock(String predictStock) {
        this.predictStock = predictStock;
    }

    public String getRealStock() {
        return realStock;
    }

    public void setRealStock(String realStock) {
        this.realStock = realStock;
    }

    public CompareStockData(String predictStock, String realStock) {
        this.predictStock = predictStock;
        this.realStock = realStock;
    }

    public CompareStockData() {
    }
}
