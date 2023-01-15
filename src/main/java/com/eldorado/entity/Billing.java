package com.eldorado.entity;

import com.eldorado.helper.Helper;

public class Billing implements Comparable<Billing>{
    private String company;
    private int month;
    private int year;
    private Installment firstInstallment;
    private Installment secondInstallment;
    private Installment thirdInstallment;
    private double totalValue;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = Helper.readInteger(month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = Helper.readInteger(year);
    }

    public Installment getFirstInstallment() {
        return firstInstallment;
    }

    public void setFirstInstallment(Installment firstInstallment) {
        this.firstInstallment = firstInstallment;
    }

    public Installment getSecondInstallment() {
        return secondInstallment;
    }

    public void setSecondInstallment(Installment secondInstallment) {
        this.secondInstallment = secondInstallment;
    }

    public Installment getThirdInstallment() {
        return thirdInstallment;
    }

    public void setThirdInstallment(Installment thirdInstallment) {
        this.thirdInstallment = thirdInstallment;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "company='" + company + '\'' +
                ", month=" + month +
                ", year=" + year +
                ", firstInstallment=" + firstInstallment +
                ", secondInstallment=" + secondInstallment +
                ", thirdInstallment=" + thirdInstallment +
                ", total=" + totalValue +
                '}';
    }

    @Override
    public int compareTo(Billing o) {
        return 0;
    }
}