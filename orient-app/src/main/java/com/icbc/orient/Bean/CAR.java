package com.icbc.orient.Bean;

public class CAR {
    private int dayCount;
    private float car;
    private float ar;

    public CAR(int dayCount,float car,float ar){
        this.ar=ar;
        this.car=car;
        this.dayCount=dayCount;
    }

    public void setAr(float ar) {
        this.ar = ar;
    }

    public void setCar(float car) {
        this.car = car;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public float getAr() {
        return ar;
    }

    public float getCar() {
        return car;
    }

    public int getDayCount() {
        return dayCount;
    }
}
