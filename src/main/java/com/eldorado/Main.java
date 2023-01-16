package com.eldorado;

import com.eldorado.entity.Billing;
import com.eldorado.entity.Invoice;
import com.eldorado.service.BillingService;
import com.eldorado.service.InvoiceService;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        String invoicePath = "C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt\\nota.txt";
        String billingPath = "C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt\\faturamento.txt";

        List<Invoice> invoices = InvoiceService.readInvoiceCSV(invoicePath);
        List<Billing> billings = BillingService.readBillingCSV(billingPath);

        Map<String, Map<String, List<Invoice>>> invoiceMap = invoices.stream()
                .collect(Collectors.groupingBy(Invoice::getCompany,
                        Collectors.groupingBy(invoice -> invoice.getMonth() + "/" + invoice.getYear())));

        Map<String, Map<String, List<Billing>>> billingMap = billings.stream()
                .collect(Collectors.groupingBy(Billing::getCompany,
                        Collectors.groupingBy(billing -> billing.getMonth() + "/" + billing.getYear())));




//        invoiceMap.entrySet().stream()
//                .filter(invoiceEntry -> billingMap.containsKey(invoiceEntry.getKey()))
//                .flatMap(invoiceEntry -> invoiceEntry.getValue().entrySet().stream()
//                        .filter(invoiceList -> billingMap.get(invoiceEntry.getKey()).containsKey(invoiceList.getKey()))
//                        .flatMap(invoiceList -> invoiceList.getValue().stream()
//                                .filter(invoice -> billingMap.get(invoiceEntry.getKey()).get(invoiceList.getKey()).stream()
//                                        .anyMatch(billing -> invoice.getValue() == billing.getTotalValue()))
//                                .map(invoice -> "Matched: " + invoice.getCompany() + " " + invoiceList.getKey())))
//                .forEach(System.out::println);





//        - agrupar lista 2 por empresa
//        - iterar sobre esse resultado agrupado
//        - pra cada iteração, verificar se X bate com find(companhia).total da lista 1
//                - se bate, inserir +1 linha no xls de quitadas
//                - se não bate, inserir +1 linha no xls de inadimplente
//
        System.out.println(invoiceMap.get("f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7"));
        System.out.println(billingMap.get("f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7"));


    }
}