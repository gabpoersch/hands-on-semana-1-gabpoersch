package com.eldorado.service;

import com.eldorado.entity.Billing;
import com.eldorado.entity.Installment;
import com.eldorado.entity.Invoice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class BillingService {

    File file = new File("C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt", "faturamento.txt");

    public static List<Billing> readBillingCSV(String filePath) {
        List<Billing> billingList = new ArrayList<>();
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";", -1);

                Billing billing = new Billing();

                billing.setCompany(values[0]);
                billing.setMonth(values[1]);
                billing.setYear(values[2]);
                billing.setFirstInstallment(new Installment(values[3], values[4]));
                billing.setSecondInstallment(new Installment(values[5], values[6]));
                billing.setThirdInstallment(new Installment(values[7], values[8]));
                billing.setTotalValue(
                        billing.getFirstInstallment().getValue() +
                        billing.getSecondInstallment().getValue() +
                        billing.getThirdInstallment().getValue());

                billingList.add(billing);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        billingList.sort(Comparator.comparing(Billing::getCompany).thenComparing(Billing::getYear).thenComparing(Billing::getMonth));

        System.out.println("Billing List size: " + billingList.size());
        return billingList;
    }

}