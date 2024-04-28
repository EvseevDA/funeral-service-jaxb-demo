package com.funeralservice.xml.service.jaxb;

import com.funeralservice.dao.AbstractDao;
import com.funeralservice.dao.AbstractProviderDao;
import com.funeralservice.pojo.Order;
import com.funeralservice.pojo.OrderedAffilation;
import com.funeralservice.pojo.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProviderServiceJaxb extends AbstractProviderDao {

    @Override
    public List<Provider> getAll() {
        List<Provider> result = new ArrayList<>();
        XmlServiceJaxb.getOrderList().forEach(o -> {
            OrderedAffilationServiceJaxb.getByOrder(o).forEach(oa -> {
                Provider provider = oa.getFuneralAffilation().getProvider();
                if (result.contains(provider) == false) {
                    result.add(provider);
                }
            });
        });

        return result;
    }

    @Override
    public Optional<Provider> getById(int id) {
        AbstractDao.requireIdNonNegative(id);
        for (Order o : XmlServiceJaxb.getOrderList()) {
            for (OrderedAffilation oa : OrderedAffilationServiceJaxb.getByOrder(o)) {
                Provider provider = oa.getFuneralAffilation().getProvider();
                if (provider.getId() == id) {
                    return Optional.of(provider);
                }
            }
        }

        return Optional.empty();
    }
}
