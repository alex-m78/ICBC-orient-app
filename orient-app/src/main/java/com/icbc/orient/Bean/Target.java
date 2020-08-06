package com.icbc.orient.Bean;

public class Target {
    private String target;
    private String feature;
    private double mean1;
    private double std1;
    private double len1;
    private double mean2;
    private double std2;
    private double len2;
    private double corr;

    public void setCorr(double corr) {
        this.corr = corr;
    }

    public double getCorr() {
        return corr;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public double getLen1() {
        return len1;
    }

    public double getLen2() {
        return len2;
    }

    public double getMean1() {
        return mean1;
    }

    public double getMean2() {
        return mean2;
    }

    public double getStd1() {
        return std1;
    }

    public double getStd2() {
        return std2;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setLen1(double len1) {
        this.len1 = len1;
    }

    public void setLen2(double len2) {
        this.len2 = len2;
    }

    public void setMean1(double mean1) {
        this.mean1 = mean1;
    }

    public void setMean2(double mean2) {
        this.mean2 = mean2;
    }

    public void setStd1(double std1) {
        this.std1 = std1;
    }

    public void setStd2(double std2) {
        this.std2 = std2;
    }
}
