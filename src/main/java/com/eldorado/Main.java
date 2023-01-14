package com.eldorado;

import com.eldorado.service.InvoiceService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt\\nota.txt";

        InvoiceService.readCSV(filePath);
    }
}