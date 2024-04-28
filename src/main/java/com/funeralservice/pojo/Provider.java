package com.funeralservice.pojo;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "provider", propOrder = {
        "name",
        "speakTo",
        "jobTitle",
        "country",
        "region",
        "city",
        "index",
        "phoneNumber"
})
public class Provider {
    @XmlAttribute(name = "providerId", required = true)
    private int id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "speakTo")
    private String speakTo;
    @XmlElement(name = "jobTitle")
    private String jobTitle;
    @XmlElement(name = "country")
    private String country;
    @XmlElement(name = "region")
    private String region;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "index")
    private String index;
    @XmlElement(name = "phoneNumber")
    private String phoneNumber;

    public Provider() {
    }

    public Provider(int id,
                    String name,
                    String speakTo,
                    String jobTitle,
                    String country,
                    String region,
                    String city,
                    String index,
                    String phoneNumber) {
        this.id = id;
        this.name = name;
        this.speakTo = speakTo;
        this.jobTitle = jobTitle;
        this.country = country;
        this.region = region;
        this.city = city;
        this.index = index;
        this.phoneNumber = phoneNumber;
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

    public String getSpeakTo() {
        return speakTo;
    }

    public void setSpeakTo(String speakTo) {
        this.speakTo = speakTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return id == provider.id
                && Objects.equals(name, provider.name)
                && Objects.equals(speakTo, provider.speakTo)
                && Objects.equals(jobTitle, provider.jobTitle)
                && Objects.equals(country, provider.country)
                && Objects.equals(region, provider.region)
                && Objects.equals(city, provider.city)
                && Objects.equals(index, provider.index)
                && Objects.equals(phoneNumber, provider.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, speakTo, jobTitle, country, region, city, index, phoneNumber);
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speakTo='" + speakTo + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", index='" + index + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}' + '\n';
    }
}
