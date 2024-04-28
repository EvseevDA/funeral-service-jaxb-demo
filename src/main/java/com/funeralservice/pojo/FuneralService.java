package com.funeralservice.pojo;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "funeralService", propOrder = {
        "orders"
})
public class FuneralService {
    @XmlElement(name = "orders")
    private Orders orders;

    public FuneralService() {
    }

    public FuneralService(Orders orders) {
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "FuneralService{" +
                "orders=" + orders +
                '}' + '\n';
    }
}
