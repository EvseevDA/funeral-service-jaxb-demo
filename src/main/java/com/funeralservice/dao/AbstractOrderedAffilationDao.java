package com.funeralservice.dao;

import com.funeralservice.pojo.Order;
import com.funeralservice.pojo.OrderedAffilation;

import java.util.List;
import java.util.Optional;

public abstract class AbstractOrderedAffilationDao extends AbstractDao<OrderedAffilation> {

    public abstract List<OrderedAffilation> getByOrderId(int id);
    public abstract Optional<OrderedAffilation> getByOrderAndAffilationId(Order o, int affilationId);
    public abstract Optional<OrderedAffilation> getByOrderIdAndAffilationId(int orderId, int affilationId);

}
