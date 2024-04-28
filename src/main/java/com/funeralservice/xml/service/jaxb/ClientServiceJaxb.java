package com.funeralservice.xml.service.jaxb;

import com.funeralservice.dao.AbstractClientDao;
import com.funeralservice.dao.AbstractDao;
import com.funeralservice.pojo.Client;
import com.funeralservice.pojo.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceJaxb extends AbstractClientDao {

    private final List<Order> orders = XmlServiceJaxb.getOrderList();

    @Override
    public List<Client> getAll() {
        List<Client> result = new ArrayList<>();
        orders.forEach(e -> {
            Client client = e.getClient();
            if (result.contains(client) == false) {
                result.add(client);
            }
        });

        return result;
    }

    @Override
    public Optional<Client> getById(int id) {
        AbstractDao.requireIdNonNegative(id);

        for (Order o : orders) {
            if (o.getClient().getId() == id) {
                return Optional.of(o.getClient());
            }
        }
        return Optional.empty();
    }
}
