package com.funeralservice.xml.service.jaxb;

import com.funeralservice.dao.AbstractDao;
import com.funeralservice.dao.AbstractOrderedServiceDao;
import com.funeralservice.pojo.Order;
import com.funeralservice.pojo.OrderedService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderedServiceServiceJaxb extends AbstractOrderedServiceDao {

    @Override
    public List<OrderedService> getAll() {
        List<OrderedService> orderedServices = new ArrayList<>();
        List<Order> orders = new OrderServiceJaxb().getAll();
        for (Order o : orders) {
            orderedServices.addAll(getByOrder(o));
        }
        return orderedServices;
    }

    @Override
    public Optional<OrderedService> getById(int id) {
        throw new UnsupportedOperationException("use getByOrderAndServiceId(Order, int) "
                + " or getByOrderIdAndServiceId(int, int)");
    }

    public static List<OrderedService> getByOrder(Order o) {
        return Objects.requireNonNull(o).getOrderedServices().getOrderedService();
    }

    @Override
    public List<OrderedService> getByOrderId(int id) {
        Optional<Order> o = new OrderServiceJaxb().getById(id);
        return o.map(OrderedServiceServiceJaxb::getByOrder).orElseGet(ArrayList::new);
    }

    @Override
    public Optional<OrderedService> getByOrderAndServiceId(Order o, int serviceId) {
        AbstractDao.requireIdNonNegative(serviceId);
        List<OrderedService> orderedServices = getByOrder(o);
        for (OrderedService os : orderedServices) {
            if (os.getService().getId() == serviceId) {
                return Optional.of(os);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrderedService> getByOrderIdAndServiceId(int orderId, int serviceId) {
        Optional<Order> o = new OrderServiceJaxb().getById(orderId);
        if (o.isPresent()) {
            return getByOrderAndServiceId(o.get(), serviceId);
        }
        return Optional.empty();
    }
}
