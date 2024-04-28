package com.funeralservice;

import com.funeralservice.xml.service.jaxb.OrderServiceJaxb;
import com.funeralservice.xml.service.xpath.ClientServiceXPath;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        OrderServiceJaxb orderServiceJaxb = new OrderServiceJaxb();
        System.out.println("Request: orderServiceJaxb.getWhereTotalPriceGreaterThan(BigDecimal.valueOf(7000))\n");
        System.out.println(orderServiceJaxb.getWhereTotalPriceGreaterThan(BigDecimal.valueOf(7000)) + "\n\n");

        System.out.println("Request: orderServiceJaxb.getAll()\n");
        printList(orderServiceJaxb.getAll(), "\n");
        System.out.println();

        System.out.println("Request: orderServiceJaxb.getTotalPricePerAllOrders()\n");
        System.out.println(orderServiceJaxb.getTotalPricePerAllOrders());
        System.out.println("\n\n");

        ClientServiceXPath clientServiceXPath = new ClientServiceXPath();
        System.out.println("Got all clients with XPath\n\n");
        clientServiceXPath
                .getAll()
                .forEach(c -> {
                    printList(c, "\n");
                    System.out.println('\n');
                });
        System.out.println("\n");

        System.out.println("Got client by id with XPath\n");
        clientServiceXPath
                .getById(0)
                .ifPresent(c -> printList(c, "\n"));
    }

    static void printList(List<?> list, String separator) {
        list.forEach(e -> System.out.print(e + separator));
    }
}