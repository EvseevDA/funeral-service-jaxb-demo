package com.funeralservice.pojo;

import javax.xml.bind.annotation.*;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "client", propOrder = {
        "surname",
        "name",
        "patronymic",
        "country",
        "region",
        "city",
        "phoneNumber",
        "index"
})
public class Client {
    @XmlAttribute(name = "clientId", required = true)
    private int id;
    @XmlElement(name = "surname")
    private String surname;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "patronymic")
    private String patronymic;
    @XmlElement(name = "country")
    private String country;
    @XmlElement(name = "region")
    private String region;
    @XmlElement(name = "city")
    private String city;

    @XmlElement(name = "phoneNumber")
    private String phoneNumber;

    @XmlElement(name = "index")
    private String index;

    public Client() {
    }

    public Client(int id,
                  String surname,
                  String name,
                  String patronymic,
                  String country,
                  String region,
                  String city,
                  String phoneNumber,
                  String index) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.country = country;
        this.region = region;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.index = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id
                && Objects.equals(surname, client.surname)
                && Objects.equals(name, client.name)
                && Objects.equals(patronymic, client.patronymic)
                && Objects.equals(country, client.country)
                && Objects.equals(region, client.region)
                && Objects.equals(city, client.city)
                && Objects.equals(phoneNumber, client.phoneNumber)
                && Objects.equals(index, client.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, country, region, city, phoneNumber, index);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", index='" + index + '\'' +
                '}' + '\n';
    }
}
