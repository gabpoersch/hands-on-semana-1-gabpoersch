package com.eldorado;

import com.eldorado.entity.Billing;
import com.eldorado.service.BIllingService;
import com.eldorado.service.InvoiceService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String invoicePath = "C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt\\nota.txt";
        String billingPath = "C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt\\faturamento.txt";

        InvoiceService.readInvoiceCSV(invoicePath);
        BIllingService.readBillingCSV(billingPath);
    }
}