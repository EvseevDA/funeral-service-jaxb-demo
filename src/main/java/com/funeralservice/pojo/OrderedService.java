package com.funeralservice.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderedService", propOrder = {
        "service",
        "price",
        "percentDiscount"
})
public class OrderedService {
    @XmlElement(name = "service")
    private Service service;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "percentDiscount")
    private int percentDiscount;

    public OrderedService() {
    }

    public OrderedService(Service service, BigDecimal price, int percentDiscount) {
        this.service = service;
        this.price = price;
        this.percentDiscount = percentDiscount;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedService that = (OrderedService) o;
        return percentDiscount == that.percentDiscount
                && Objects.equals(service, that.service)
                && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service, price, percentDiscount);
    }

    @Override
    public String toString() {
        return "OrderedService{" +
                "service=" + service +
                ", price=" + price +
                ", percentDiscount=" + percentDiscount +
                '}' + '\n';
    }
}
