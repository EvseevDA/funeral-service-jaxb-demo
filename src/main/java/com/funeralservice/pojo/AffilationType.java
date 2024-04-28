package com.funeralservice.pojo;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "affilationType", propOrder = {
        "category",
        "description"
})
public class AffilationType {
    @XmlAttribute(name = "typeId", required = true)
    private int id;
    @XmlElement(name = "category")
    private String category;
    @XmlElement(name = "description")
    private String description;

    public AffilationType() {
    }

    public AffilationType(int id, String category, String description) {
        this.id = id;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        AffilationType that = (AffilationType) o;
        return id == that.id && Objects.equals(category, that.category) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, description);
    }

    @Override
    public String toString() {
        return "AfiilationType{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}' + '\n';
    }
}
