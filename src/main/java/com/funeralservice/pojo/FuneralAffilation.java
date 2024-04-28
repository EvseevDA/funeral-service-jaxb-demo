package com.funeralservice.pojo;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "funeralAffilation", propOrder = {
        "name",
        "provider",
        "affilationType",
        "unit",
        "price",
        "inStorage",
        "expected",
        "suppliesStopped",
        "photoUrl",
        "description"
})
public class FuneralAffilation {
    @XmlAttribute(name = "affilationId", required = true)
    private int id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "provider")
    private Provider provider;
    @XmlElement(name = "affilationType")
    private AffilationType affilationType;
    @XmlElement(name = "unit")
    private String unit;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "inStorage")
    private int inStorage;
    @XmlElement(name = "expected")
    private int expected;
    @XmlElement(name = "suppliesStopped")
    private boolean suppliesStopped;
    @XmlElement(name = "photoUrl")
    private String photoUrl;
    @XmlElement(name = "description")
    private String description;

    public FuneralAffilation() {
    }

    public FuneralAffilation(int id,
                             String name,
                             Provider provider,
                             AffilationType type,
                             String unit,
                             BigDecimal price,
                             int inStorage,
                             int expected,
                             boolean suppliesStopped,
                             String photoUrl,
                             String description) {
        this.id = id;
        this.name = name;
        this.provider = provider;
        this.affilationType = type;
        this.unit = unit;
        this.price = price;
        this.inStorage = inStorage;
        this.expected = expected;
        this.suppliesStopped = suppliesStopped;
        this.photoUrl = photoUrl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public AffilationType getAffilationType() {
        return affilationType;
    }

    public void setAffilationType(AffilationType affilationType) {
        this.affilationType = affilationType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getInStorage() {
        return inStorage;
    }

    public void setInStorage(int inStorage) {
        this.inStorage = inStorage;
    }

    public int getExpected() {
        return expected;
    }

    public void setExpected(int expected) {
        this.expected = expected;
    }

    public boolean isSuppliesStopped() {
        return suppliesStopped;
    }

    public void setSuppliesStopped(boolean suppliesStopped) {
        this.suppliesStopped = suppliesStopped;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuneralAffilation that = (FuneralAffilation) o;
        return id == that.id
                && inStorage == that.inStorage
                && expected == that.expected
                && suppliesStopped == that.suppliesStopped
                && Objects.equals(name, that.name)
                && Objects.equals(provider, that.provider)
                && Objects.equals(affilationType, that.affilationType)
                && Objects.equals(unit, that.unit)
                && Objects.equals(price, that.price)
                && Objects.equals(photoUrl, that.photoUrl)
                && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, provider, affilationType, unit, price, inStorage, expected, suppliesStopped, photoUrl, description);
    }

    @Override
    public String toString() {
        return "FuneralAffilation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", provider=" + provider +
                ", type=" + affilationType +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", inStorage=" + inStorage +
                ", expected=" + expected +
                ", suppliesStopped=" + suppliesStopped +
                ", photoUrl='" + photoUrl + '\'' +
                ", description='" + description + '\'' +
                '}' + '\n';
    }
}
