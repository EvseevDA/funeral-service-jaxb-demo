package com.funeralservice.xml.service.jaxb;

import com.funeralservice.dao.AbstractDao;
import com.funeralservice.dao.AbstractOrderedAffilationDao;
import com.funeralservice.pojo.Order;
import com.funeralservice.pojo.OrderedAffilation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderedAffilationServiceJaxb extends AbstractOrderedAffilationDao {

    @Override
    public List<OrderedAffilation> getAll() {
        List<Order> orders = XmlServiceJaxb.getOrderList();
        List<OrderedAffilation> orderedAffilations = new ArrayList<>();
        for (Order o : orders) {
            orderedAffilations.addAll(getByOrder(o));
        }
        return orderedAffilations;
    }

    @Override
    public Optional<OrderedAffilation> getById(int id) {
        throw new UnsupportedOperationException("use getByOrderAndAffilationId(Order, int) " +
                                                " or getByOrderIdAndAffilationId(int, int)");
    }

    public static List<OrderedAffilation> getByOrder(Order o) {
        return o.getOrderedAffilations().getOrderedAffilation();
    }

    @Override
    public List<OrderedAffilation> getByOrderId(int id) {
        Optional<Order> order = new OrderServiceJaxb().getById(id);
        return order.map(OrderedAffilationServiceJaxb::getByOrder).orElseGet(ArrayList::new);
    }

    @Override
    public Optional<OrderedAffilation> getByOrderAndAffilationId(Order o, int affilationId) {
        AbstractDao.requireIdNonNegative(affilationId);
        List<OrderedAffilation> orderedAffilations = getByOrder(o);
        for (OrderedAffilation oa : orderedAffilations) {
            if (oa.getFuneralAffilation().getId() == affilationId) {
                return Optional.of(oa);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrderedAffilation> getByOrderIdAndAffilationId(int orderId, int affilationId) {
        Optional<Order> o = new OrderServiceJaxb().getById(orderId);
        if (o.isPresent()) {
            return getByOrderAndAffilationId(o.get(), affilationId);
        }
        return Optional.empty();
    }
}
