package com.funeralservice.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderedAffilations", propOrder = {
        "orderedAffilation"
})
public class OrderedAffilations {

    @XmlElement(name = "orderedAffilation")
    private List<OrderedAffilation> orderedAffilation = new ArrayList<>();

    public OrderedAffilations() {
    }

    public OrderedAffilations(List<OrderedAffilation> orderedAffilationList) {
        this.orderedAffilation = orderedAffilationList;
    }

    public List<OrderedAffilation> getOrderedAffilation() {
        return orderedAffilation;
    }

    public void setOrderedAffilation(List<OrderedAffilation> orderedAffilation) {
        this.orderedAffilation = orderedAffilation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedAffilations that = (OrderedAffilations) o;
        return Objects.equals(orderedAffilation, that.orderedAffilation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderedAffilation);
    }

    @Override
    public String toString() {
        return "OrderedAffilations{" +
                "orderedAffilationList=" + orderedAffilation +
                '}' + '\n';
    }
}
