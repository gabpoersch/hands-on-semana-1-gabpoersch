package com.eldorado.service;

import com.eldorado.entity.Invoice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceService {

    File file = new File("C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt", "faturamento.txt");

    public static List<Invoice> readCSV(String fileName) {
        List<Invoice> invoices = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] values = line.split(";");
                Invoice invoice = new Invoice();
                invoice.setCompany(values[0]);
                invoice.setMonth(Integer.parseInt(values[1]));
                invoice.setYear(Integer.parseInt(values[2]));
                invoice.setValue(Double.parseDouble(values[3]));
                invoice.setIssuingDate(values[4]);
                invoice.setInvoice(values[5]);
                invoices.add(invoice);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return invoices;
    }
}