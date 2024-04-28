package com.funeralservice.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderedServices", propOrder = {
        "orderedService"
})
public class OrderedServices {
    @XmlElement(name = "orderedService")
    private List<OrderedService> orderedService = new ArrayList<>();

    public OrderedServices() {
    }

    public OrderedServices(List<OrderedService> orderedServiceList) {
        this.orderedService = orderedServiceList;
    }

    public List<OrderedService> getOrderedService() {
        return orderedService;
    }

    public void setOrderedService(List<OrderedService> orderedService) {
        this.orderedService = orderedService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedServices that = (OrderedServices) o;
        return Objects.equals(orderedService, that.orderedService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderedService);
    }

    @Override
    public String toString() {
        return "OrderedServices{" +
                "orderedServiceList=" + orderedService +
                '}' + '\n';
    }
}
