package com.funeralservice.xml.service.jaxb;

import com.funeralservice.dao.AbstractDao;
import com.funeralservice.dao.AbstractFuneralAffilationDao;
import com.funeralservice.pojo.FuneralAffilation;
import com.funeralservice.pojo.Order;
import com.funeralservice.pojo.OrderedAffilation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuneralAffilationServiceJaxb extends AbstractFuneralAffilationDao {

    @Override
    public List<FuneralAffilation> getAll() {
        List<FuneralAffilation> result = new ArrayList<>();
        XmlServiceJaxb
                .getOrderList()
                .forEach(o -> {
                    OrderedAffilationServiceJaxb
                            .getByOrder(o)
                            .forEach(e -> {
                                FuneralAffilation affilation = e.getFuneralAffilation();
                                if (result.contains(affilation) == false) {
                                    result.add(e.getFuneralAffilation());
                                }
                            });
                });

        return result;
    }

    @Override
    public Optional<FuneralAffilation> getById(int id) {
        AbstractDao.requireIdNonNegative(id);

        for (Order o : XmlServiceJaxb.getOrderList()) {
            for (OrderedAffilation oa : OrderedAffilationServiceJaxb.getByOrder(o)) {
                if (oa.getFuneralAffilation().getId() == id) {
                    return Optional.of(oa.getFuneralAffilation());
                }
            }
        }
        return Optional.empty();
    }
}
