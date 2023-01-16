package com.eldorado;

import com.eldorado.entity.Billing;
import com.eldorado.entity.Invoice;
import com.eldorado.service.BillingService;
import com.eldorado.service.InvoiceService;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        String invoicePath = "C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt\\nota.txt";
        String billingPath = "C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt\\faturamento.txt";

        List<Invoice> invoiceList = InvoiceService.readInvoiceCSV(invoicePath);
        List<Billing> billingList = BillingService.readBillingCSV(billingPath);

        Map<String, Map<String, List<Invoice>>> invoiceMap = invoiceList.stream()
                .collect(Collectors.groupingBy(Invoice::getCompany,
                        Collectors.groupingBy(invoice -> invoice.getMonth() + "/" + invoice.getYear())));

        Map<String, Map<String, List<Billing>>> billingMap = billingList.stream()
                .collect(Collectors.groupingBy(Billing::getCompany,
                        Collectors.groupingBy(billing -> billing.getMonth() + "/" + billing.getYear())));

        List<String> invoiceStringList = invoiceList.stream()
                .collect(Collectors.groupingBy(Invoice::getCompany,
                        Collectors.groupingBy(invoice -> invoice.getMonth() + "/" + invoice.getYear())))
                .entrySet().stream()
                .flatMap(outerEntry -> outerEntry.getValue().entrySet().stream()
                        .flatMap(innerEntry -> innerEntry.getValue().stream()
                                .map(invoice -> outerEntry.getKey() + "," + innerEntry.getKey() + "," + invoice.getValue())))
                .collect(Collectors.toList());

        List<String> companiesBefore = invoiceStringList.stream()
                .map(s -> s.split(",")[0])
                .distinct()
                .collect(Collectors.toList());


        List<String> billingStringList = billingList.stream()
                .collect(Collectors.groupingBy(Billing::getCompany,
                        Collectors.groupingBy(billing -> billing.getMonth() + "/" + billing.getYear())))
                .entrySet().stream()
                .flatMap(outerEntry -> outerEntry.getValue().entrySet().stream()
                        .flatMap(innerEntry -> innerEntry.getValue().stream()
                                .map(billing -> outerEntry.getKey() + "," + innerEntry.getKey() + "," + billing.getTotalValue())))
                .collect(Collectors.toList());

        invoiceStringList.removeIf(billingStringList::contains);

        List<String> companiesAfter = invoiceStringList.stream()
                .map(s -> s.split(",")[0])
                .distinct()
                .collect(Collectors.toList());

        companiesBefore.removeIf(companiesAfter::contains);


        try (BufferedWriter bw = new BufferedWriter(new FileWriter("compliant_companies.txt"))) {
            for (String company : companiesBefore) {
                bw.write(company);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("defaulter_companies.txt"))) {
            for (String company : companiesAfter) {
                bw.write(company);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}