package com.eldorado.service;

import com.eldorado.entity.Invoice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    File file = new File("C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt", "nota.txt");

    public static List<Invoice> readInvoiceCSV(String filePath) {
        List<Invoice> invoices = new ArrayList<>();
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            br.readLine();

            while((line = br.readLine()) != null) {
                String[] values = line.split(";", -1);

                Invoice invoice = new Invoice();
                invoice.setCompany(values[0]);
                invoice.setMonth(values[1]);
                invoice.setYear(values[2]);
                invoice.setValue(values[3]);
                invoice.setIssuingDate(values[4]);
                invoice.setInvoice(values[5]);

                invoices.add(invoice);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Invoice List size: " + invoices.size());
        return invoices;
    }

}