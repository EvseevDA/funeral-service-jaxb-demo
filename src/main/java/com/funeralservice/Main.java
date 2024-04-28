package com.funeralservice;

import com.funeralservice.xml.service.jaxb.OrderServiceJaxb;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        OrderServiceJaxb orderServiceJaxb = new OrderServiceJaxb();
        System.out.println(orderServiceJaxb.getWhereTotalPriceGreaterThan(BigDecimal.valueOf(7000)));
        printList(orderServiceJaxb.getAll(), '\n');
        System.out.println(orderServiceJaxb.getTotalPricePerAllOrders());
    }

    static void printList(List<?> list, char separator) {
        list.forEach(e -> System.out.print(Objects.toString(e) + separator));
    }
}