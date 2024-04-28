package com.funeralservice.dao;

import com.funeralservice.pojo.Order;
import com.funeralservice.pojo.OrderedService;

import java.util.List;
import java.util.Optional;

public abstract class AbstractOrderedServiceDao extends AbstractDao<OrderedService> {
    public abstract List<OrderedService> getByOrderId(int id);
    public abstract Optional<OrderedService> getByOrderAndServiceId(Order o, int serviceId);
    public abstract Optional<OrderedService> getByOrderIdAndServiceId(int orderId, int serviceId);
}
