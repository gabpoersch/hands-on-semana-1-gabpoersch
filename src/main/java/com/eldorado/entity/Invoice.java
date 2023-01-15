package com.eldorado.entity;

import com.eldorado.helper.Helper;

public class Invoice {
    private String company;
    private int month;
    private int year;
    private double value;
    private String issuingDate;
    private String invoice;

    public Invoice(String company, int month, int year, double value, String issuingDate, String invoice) {
        this.company = company;
        this.month = month;
        this.year = year;
        this.value = value;
        this.issuingDate = issuingDate;
        this.invoice = invoice;
    }

    public Invoice() {

    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    public void setMonth(String month) {
        this.year = Helper.readInteger(month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void setYear(String year) {
        this.year = Helper.readInteger(year);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = Helper.readDouble(value);
    }

    public String getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(String issuingDate) {
        this.issuingDate = issuingDate;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "company='" + company + '\'' +
                ", month=" + month +
                ", year=" + year +
                ", value=" + value +
                ", issuingDate='" + issuingDate + '\'' +
                ", invoice='" + invoice + '\'' +
                '}';
    }
}