package com.funeralservice.xml.service.jaxb;

import com.funeralservice.dao.AbstractDao;
import com.funeralservice.dao.AbstractServiceDao;
import com.funeralservice.pojo.Order;
import com.funeralservice.pojo.OrderedService;
import com.funeralservice.pojo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceServiceJaxb extends AbstractServiceDao {

    @Override
    public List<Service> getAll() {
        List<Service> result = new ArrayList<>();

        XmlServiceJaxb.getOrderList().forEach(o -> {
            OrderedServiceServiceJaxb.getByOrder(o).forEach(os -> {
                if (result.contains(os.getService()) == false) {
                    result.add(os.getService());
                }
            });
        });

        return result;
    }

    @Override
    public Optional<Service> getById(int id) {
        AbstractDao.requireIdNonNegative(id);

        for (Order o : XmlServiceJaxb.getOrderList()) {
            for (OrderedService os : OrderedServiceServiceJaxb.getByOrder(o)) {
                if (os.getService().getId() == id) {
                    return Optional.of(os.getService());
                }
            }
        }
        return Optional.empty();
    }
}
