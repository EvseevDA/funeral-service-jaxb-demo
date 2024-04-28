package com.funeralservice.pojo;


import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orders", propOrder = {
        "order"
})
public class Orders {

    @XmlElement(name = "order")
    private List<Order> order = new ArrayList<>();

    public Orders() {
    }

    public Orders(List<Order> order) {
        this.order = order;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> orders) {
        this.order = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders1 = (Orders) o;
        return Objects.equals(order, orders1.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders=" + order +
                '}' + '\n';
    }
}
