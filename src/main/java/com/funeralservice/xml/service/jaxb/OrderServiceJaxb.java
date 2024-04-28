package com.funeralservice.xml.service.jaxb;

import com.funeralservice.dao.AbstractDao;
import com.funeralservice.dao.AbstractOrderDao;
import com.funeralservice.pojo.Order;
import com.funeralservice.pojo.OrderedAffilation;
import com.funeralservice.pojo.OrderedService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderServiceJaxb extends AbstractOrderDao {

    @Override
    public List<Order> getAll() {
        return XmlServiceJaxb.getOrderList();
    }

    @Override
    public Optional<Order> getById(int id) {
        AbstractDao.requireIdNonNegative(id);

        List<Order> orders = XmlServiceJaxb.getOrderList();
        for (Order o : orders) {
            if (o.getId() == id) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Order> getWhereTotalPriceGreaterThan(BigDecimal price) {
        validatePrice(price);

        List<Order> result = new ArrayList<>();
        List<Order> orders = XmlServiceJaxb.getOrderList();
        for (Order o : orders) {
            BigDecimal sum = BigDecimal.ZERO;
            calculations:
            {
                for (OrderedService os : OrderedServiceServiceJaxb.getByOrder(o)) {
                    BigDecimal currentPrice = os.getPrice();
                    BigDecimal discount = BigDecimal.valueOf(os.getPercentDiscount()).divide(BigDecimal.valueOf(100));
                    sum = sum.add(currentPrice.subtract(currentPrice.multiply(discount)));
                    if (sum.compareTo(price) > 0) {
                        result.add(o);
                        break calculations;
                    }
                }

                for (OrderedAffilation oa : OrderedAffilationServiceJaxb.getByOrder(o)) {
                    BigDecimal pricePerUnit = oa.getPrice();
                    BigDecimal count = BigDecimal.valueOf(oa.getAffilationCount());
                    BigDecimal discount = BigDecimal.valueOf(oa.getPercentDiscount()).divide(BigDecimal.valueOf(100));
                    BigDecimal priceWithoutDiscount = pricePerUnit.multiply(count);
                    // price - (price * discount)
                    sum = sum.add(priceWithoutDiscount.subtract(priceWithoutDiscount.multiply(discount)));
                    if (sum.compareTo(price) > 0) {
                        result.add(o);
                        break calculations;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public BigDecimal getTotalPricePerAllOrders() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        List<Order> orders = XmlServiceJaxb.getOrderList();

        for (Order o : orders) {
            for (OrderedService os : OrderedServiceServiceJaxb.getByOrder(o)) {
                BigDecimal price = os.getPrice();
                BigDecimal discount = BigDecimal.valueOf(os.getPercentDiscount()).divide(BigDecimal.valueOf(100));
                BigDecimal priceWithDiscount = price.subtract(price.multiply(discount));
                totalPrice = totalPrice.add(priceWithDiscount);
            }

            for (OrderedAffilation oa : OrderedAffilationServiceJaxb.getByOrder(o)) {
                BigDecimal pricePerUnit = oa.getPrice();
                BigDecimal discount = BigDecimal.valueOf(oa.getPercentDiscount()).divide(BigDecimal.valueOf(100));
                BigDecimal price = pricePerUnit.multiply(BigDecimal.valueOf(oa.getAffilationCount()));
                BigDecimal priceWithDiscount = price.subtract(price.multiply(discount));
                totalPrice = totalPrice.add(priceWithDiscount);
            }
        }
        return totalPrice;
    }

    private static BigDecimal validatePrice(BigDecimal price) {
        Objects.requireNonNull(price);

        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new AssertionError("price must be greater than zero. Now is " + price + ".");
        }
        return price;
    }
}
