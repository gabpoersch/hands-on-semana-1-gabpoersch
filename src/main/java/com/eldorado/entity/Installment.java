package com.eldorado.entity;

import com.eldorado.helper.Helper;

public class Installment {
    private String date;
    private double value;

    public Installment(String date, String value) {
        this.date = date;
        this.value = Helper.readDouble(value);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = Helper.readDouble(value);
    }

    @Override
    public String toString() {
        return "Installment{" +
                "date='" + date + '\'' +
                ", value=" + value +
                '}';
    }
}