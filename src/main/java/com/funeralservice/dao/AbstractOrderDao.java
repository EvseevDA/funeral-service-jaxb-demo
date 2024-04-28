package com.funeralservice.dao;

import com.funeralservice.pojo.Order;

import java.math.BigDecimal;
import java.util.List;

public abstract class AbstractOrderDao extends AbstractDao<Order> {

    public abstract List<Order> getWhereTotalPriceGreaterThan(BigDecimal price);
    public abstract BigDecimal getTotalPricePerAllOrders();

}
