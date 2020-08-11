package com.icbc.orient.Bean;

public class Industry {
    private String industryName;
    private int count;

    public Industry() {
    }

//    public Industry(String industryName,int count){
//        this.industryName=industryName;
//        this.count=count;
//    }

    public int getCount() {
        return count;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
