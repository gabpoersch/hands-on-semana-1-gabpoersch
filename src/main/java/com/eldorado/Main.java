package com.eldorado;

import com.eldorado.entity.Billing;
import com.eldorado.entity.Invoice;
import com.eldorado.service.BillingService;
import com.eldorado.service.InvoiceService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        String invoicePath = "C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt\\nota.txt";
        String billingPath = "C:\\Users\\Software Development\\Desktop\\Eldorado Tech\\hands-on-semana-1-gabpoersch\\src\\main\\resources\\txt\\faturamento.txt";

        Stream<Invoice> invoices = InvoiceService.readInvoiceCSV(invoicePath);
        Stream<Billing> billings = BillingService.readBillingCSV(billingPath);

        Map<String, List<Invoice>> invoiceMap = invoices.collect(groupingBy(Invoice::getCompany));
        Map<String, List<Billing>> billingMap = billings.collect(groupingBy(Billing::getCompany));


//        - agrupar lista 2 por empresa
//        - iterar sobre esse resultado agrupado
//        - pra cada iteração, verificar se X bate com find(companhia).total da lista 1
//                - se bate, inserir +1 linha no xls de quitadas
//                - se não bate, inserir +1 linha no xls de inadimplente

        System.out.println(invoiceMap.get("f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7"));
        System.out.println(billingMap.get("f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7"));


    }
}


//[Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=12, year=2020, value=419369.685, issuingDate='05/01/21', invoice='8183'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=2, year=2021, value=416145.5175, issuingDate='01/03/21', invoice='10165'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=1, year=2021, value=410527.29, issuingDate='02/02/21', invoice='9167'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=6, year=2021, value=403890.4725, issuingDate='01/07/21', invoice='14283'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=5, year=2021, value=407684.1375, issuingDate='01/06/21', invoice='13243'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=4, year=2021, value=404950.8075, issuingDate='03/05/21', invoice='12197'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=8, year=2021, value=495151.2675, issuingDate='31/08/21', invoice='16396'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=7, year=2021, value=499371.0825, issuingDate='30/07/21', invoice='15336'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=3, year=2021, value=414896.0775, issuingDate='05/04/21', invoice='11181'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=8, year=2020, value=438812.9925, issuingDate='02/09/20', invoice='4349'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=9, year=2020, value=435821.685, issuingDate='01/10/20', invoice='5306'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=7, year=2020, value=442325.565, issuingDate='04/08/20', invoice='3393'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=11, year=2020, value=423722.28, issuingDate='03/12/20', invoice='7215'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=10, year=2020, value=427857.5475, issuingDate='03/11/20', invoice='6254'},
//        Invoice{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=9, year=2021, value=489530.7075, issuingDate='04/10/21', invoice='17475'}]
//        [
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=4, year=2020, firstInstallment=Installment{date='15/05/20', value=101190.57}, secondInstallment=Installment{date='25/05/20', value=101190.57}, thirdInstallment=Installment{date='05/06/20', value=101190.5625}, total=303571.7025},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=6, year=2020, firstInstallment=Installment{date='15/07/20', value=0.0}, secondInstallment=Installment{date='25/07/20', value=481782.465}, thirdInstallment=Installment{date='05/08/20', value=0.0}, total=481782.465},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=5, year=2020, firstInstallment=Installment{date='15/06/20', value=159255.81}, secondInstallment=Installment{date='25/06/20', value=159255.81}, thirdInstallment=Installment{date='05/07/20', value=159255.8025}, total=477767.4225},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=7, year=2020, firstInstallment=Installment{date='15/08/20', value=0.0}, secondInstallment=Installment{date='25/08/20', value=442325.565}, thirdInstallment=Installment{date='05/09/20', value=0.0}, total=442325.565},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=9, year=2020, firstInstallment=Installment{date='15/10/20', value=0.0}, secondInstallment=Installment{date='25/10/20', value=435821.685}, thirdInstallment=Installment{date='05/11/20', value=0.0}, total=435821.685},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=8, year=2020, firstInstallment=Installment{date='15/09/20', value=0.0}, secondInstallment=Installment{date='25/09/20', value=438812.9925}, thirdInstallment=Installment{date='05/10/20', value=0.0}, total=438812.9925},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=10, year=2020, firstInstallment=Installment{date='15/11/20', value=0.0}, secondInstallment=Installment{date='25/11/20', value=427857.5475}, thirdInstallment=Installment{date='05/12/20', value=0.0}, total=427857.5475},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=1, year=2021, firstInstallment=Installment{date='15/02/21', value=0.0}, secondInstallment=Installment{date='25/02/21', value=410527.29}, thirdInstallment=Installment{date='05/03/21', value=0.0}, total=410527.29},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=11, year=2020, firstInstallment=Installment{date='15/12/20', value=0.0}, secondInstallment=Installment{date='25/12/20', value=423722.28}, thirdInstallment=Installment{date='05/01/21', value=0.0}, total=423722.28},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=12, year=2020, firstInstallment=Installment{date='15/01/21', value=0.0}, secondInstallment=Installment{date='25/01/21', value=419369.685}, thirdInstallment=Installment{date='05/02/21', value=0.0}, total=419369.685},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=6, year=2021, firstInstallment=Installment{date='15/07/21', value=0.0}, secondInstallment=Installment{date='25/07/21', value=403890.4725}, thirdInstallment=Installment{date='05/08/21', value=0.0}, total=403890.4725},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=2, year=2021, firstInstallment=Installment{date='15/03/21', value=0.0}, secondInstallment=Installment{date='25/03/21', value=416145.5175}, thirdInstallment=Installment{date='05/04/21', value=0.0}, total=416145.5175},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=11, year=2021, firstInstallment=Installment{date='15/12/21', value=0.0}, secondInstallment=Installment{date='25/12/21', value=503695.755}, thirdInstallment=Installment{date='05/01/22', value=0.0}, total=503695.755},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=4, year=2021, firstInstallment=Installment{date='15/05/21', value=0.0}, secondInstallment=Installment{date='25/05/21', value=404950.8075}, thirdInstallment=Installment{date='05/06/21', value=0.0}, total=404950.8075},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=8, year=2021, firstInstallment=Installment{date='15/09/21', value=0.0}, secondInstallment=Installment{date='25/09/21', value=495151.2675}, thirdInstallment=Installment{date='05/10/21', value=0.0}, total=495151.2675},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=3, year=2021, firstInstallment=Installment{date='15/04/21', value=0.0}, secondInstallment=Installment{date='25/04/21', value=414896.0775}, thirdInstallment=Installment{date='05/05/21', value=0.0}, total=414896.0775},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=10, year=2021, firstInstallment=Installment{date='15/11/21', value=0.0}, secondInstallment=Installment{date='25/11/21', value=504494.205}, thirdInstallment=Installment{date='05/12/21', value=0.0}, total=504494.205},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=12, year=2021, firstInstallment=Installment{date='15/01/22', value=0.0}, secondInstallment=Installment{date='25/01/22', value=500607.1875}, thirdInstallment=Installment{date='05/02/22', value=0.0}, total=500607.1875},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=7, year=2021, firstInstallment=Installment{date='15/08/21', value=0.0}, secondInstallment=Installment{date='25/08/21', value=499371.0825}, thirdInstallment=Installment{date='05/09/21', value=0.0}, total=499371.0825},
//        Billing{company='f9af79a2edb58bc6327ea8bd00e21fb8ca5b55a56077f5664480a23cdd2097e7', month=5, year=2021, firstInstallment=Installment{date='15/06/21', value=0.0}, secondInstallment=Installment{date='25/06/21', value=407684.1375}, thirdInstallment=Installment{date='05/07/21', value=0.0}, total=407684.1375}]
