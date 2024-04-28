package com.funeralservice.pojo;

import javax.xml.bind.annotation.XmlType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employee", propOrder = {
        "surname",
        "name",
        "patronymic",
        "jobTitle",
        "birthday",
        "hireDate",
        "country",
        "region",
        "city",
        "district",
        "street",
        "houseNumber",
        "apartamentNumber",
        "phoneNumber",
        "photoUrl",
        "note",
        "reportsTo"
})
public class Employee {
    @XmlAttribute(name = "employeeId", required = true)
    private int id;
    @XmlElement(name = "surname")
    private String surname;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "patronymic")
    private String patronymic;
    @XmlElement(name = "jobTitle")
    private String jobTitle;
    @XmlElement(name = "birthday")
    private XMLGregorianCalendar birthday;
    @XmlElement(name = "hireDate")
    private XMLGregorianCalendar hireDate;
    @XmlElement(name = "country")
    private String country;
    @XmlElement(name = "region")
    private String region;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "district")
    private String district;
    @XmlElement(name = "street")
    private String street;
    @XmlElement(name = "houseNumber")
    private String houseNumber;
    @XmlElement(name = "apartamentNumber")
    private String apartamentNumber;
    @XmlElement(name = "phoneNumber")
    private String phoneNumber;
    @XmlElement(name = "photoUrl")
    private String photoUrl;
    @XmlElement(name = "note")
    private String note;
    @XmlElement(name = "reportsTo")
    private String reportsTo;

    public Employee() {
    }

    public Employee(int id,
                    String surname,
                    String name,
                    String patronymic,
                    String jobTitle,
                    XMLGregorianCalendar birthday,
                    XMLGregorianCalendar hireDate,
                    String country,
                    String region,
                    String city,
                    String district,
                    String street,
                    String houseNumber,
                    String apartamentNumber,
                    String phoneNumber,
                    String photoUrl,
                    String note,
                    String reportsTo) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.jobTitle = jobTitle;
        this.birthday = birthday;
        this.hireDate = hireDate;
        this.country = country;
        this.region = region;
        this.city = city;
        this.district = district;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartamentNumber = apartamentNumber;
        this.phoneNumber = phoneNumber;
        this.photoUrl = photoUrl;
        this.note = note;
        this.reportsTo = reportsTo;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public XMLGregorianCalendar getBirthday() {
        return birthday;
    }

    public void setBirthday(XMLGregorianCalendar birthday) {
        this.birthday = birthday;
    }

    public XMLGregorianCalendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(XMLGregorianCalendar hireDate) {
        this.hireDate = hireDate;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartamentNumber() {
        return apartamentNumber;
    }

    public void setApartamentNumber(String apartamentNumber) {
        this.apartamentNumber = apartamentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id
                && Objects.equals(surname, employee.surname)
                && Objects.equals(name, employee.name)
                && Objects.equals(patronymic, employee.patronymic)
                && Objects.equals(jobTitle, employee.jobTitle)
                && Objects.equals(birthday, employee.birthday)
                && Objects.equals(hireDate, employee.hireDate)
                && Objects.equals(country, employee.country)
                && Objects.equals(region, employee.region)
                && Objects.equals(city, employee.city)
                && Objects.equals(district, employee.district)
                && Objects.equals(street, employee.street)
                && Objects.equals(houseNumber, employee.houseNumber)
                && Objects.equals(apartamentNumber, employee.apartamentNumber)
                && Objects.equals(phoneNumber, employee.phoneNumber)
                && Objects.equals(photoUrl, employee.photoUrl)
                && Objects.equals(note, employee.note)
                && Objects.equals(reportsTo, employee.reportsTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                surname,
                name,
                patronymic,
                jobTitle,
                birthday,
                hireDate,
                country,
                region,
                city,
                district,
                street,
                houseNumber,
                apartamentNumber,
                phoneNumber,
                photoUrl,
                note,
                reportsTo);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", birthday=" + birthday +
                ", hireDate=" + hireDate +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartamentNumber='" + apartamentNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", note='" + note + '\'' +
                ", reportsTo='" + reportsTo + '\'' +
                '}' + '\n';
    }
}
