package com.funeralservice.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderedAffilation", propOrder = {
        "funeralAffilation",
        "price",
        "affilationCount",
        "percentDiscount"
})
public class OrderedAffilation {
    @XmlElement(name = "funeralAffilation")
    private FuneralAffilation funeralAffilation;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "affilationCount")
    private int affilationCount;
    @XmlElement(name = "percentDiscount")
    private int percentDiscount;

    public OrderedAffilation() {
    }

    public OrderedAffilation(FuneralAffilation funeralAffilation,
                             BigDecimal price,
                             int affilationCount,
                             int percentDiscount) {
        this.funeralAffilation = funeralAffilation;
        this.price = price;
        this.affilationCount = affilationCount;
        this.percentDiscount = percentDiscount;
    }

    public FuneralAffilation getFuneralAffilation() {
        return funeralAffilation;
    }

    public void setFuneralAffilation(FuneralAffilation funeralAffilation) {
        this.funeralAffilation = funeralAffilation;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAffilationCount() {
        return affilationCount;
    }

    public void setAffilationCount(int affilationCount) {
        this.affilationCount = affilationCount;
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
        OrderedAffilation that = (OrderedAffilation) o;
        return affilationCount == that.affilationCount && percentDiscount == that.percentDiscount && Objects.equals(funeralAffilation, that.funeralAffilation) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funeralAffilation, price, affilationCount, percentDiscount);
    }

    @Override
    public String toString() {
        return "OrderedAffilation{" +
                "funeralAffilation=" + funeralAffilation +
                ", price=" + price +
                ", affilationCount=" + affilationCount +
                ", percentDiscount=" + percentDiscount +
                '}' + '\n';
    }
}
