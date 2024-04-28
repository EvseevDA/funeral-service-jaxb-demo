package com.funeralservice.pojo;

import javax.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order", propOrder = {
        "client",
        "registrationDate",
        "appointmentDate",
        "executionDate",
        "employeesInOrder",
        "orderedServices",
        "orderedAffilations"
})
public class Order {
    @XmlAttribute(name = "orderId", required = true)
    private int id;
    @XmlElement(name = "client")
    private Client client;
    @XmlElement(name = "registrationDate")
    private XMLGregorianCalendar registrationDate;
    @XmlElement(name = "appointmentDate")
    private XMLGregorianCalendar appointmentDate;
    @XmlElement(name = "executionDate")
    private XMLGregorianCalendar executionDate;
    @XmlElement(name = "employeesInOrder")
    private EmployeesInOrder employeesInOrder;
    @XmlElement(name = "orderedServices")
    private OrderedServices orderedServices;
    @XmlElement(name = "orderedAffilations")
    private OrderedAffilations orderedAffilations;

    public Order() {
    }

    public Order(int id,
                 Client client,
                 XMLGregorianCalendar registrationDate,
                 XMLGregorianCalendar appointmentDate,
                 XMLGregorianCalendar executionDate,
                 EmployeesInOrder employeesInOrder,
                 OrderedServices orderedServices,
                 OrderedAffilations orderedAffilations) {
        this.id = id;
        this.client = client;
        this.registrationDate = registrationDate;
        this.appointmentDate = appointmentDate;
        this.executionDate = executionDate;
        this.employeesInOrder = employeesInOrder;
        this.orderedServices = orderedServices;
        this.orderedAffilations = orderedAffilations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public XMLGregorianCalendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(XMLGregorianCalendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    public XMLGregorianCalendar getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(XMLGregorianCalendar appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public XMLGregorianCalendar getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(XMLGregorianCalendar executionDate) {
        this.executionDate = executionDate;
    }

    public EmployeesInOrder getEmployeesInOrder() {
        return employeesInOrder;
    }

    public void setEmployeesInOrder(EmployeesInOrder employeesInOrder) {
        this.employeesInOrder = employeesInOrder;
    }

    public OrderedServices getOrderedServices() {
        return orderedServices;
    }

    public void setOrderedServices(OrderedServices orderedServices) {
        this.orderedServices = orderedServices;
    }

    public OrderedAffilations getOrderedAffilations() {
        return orderedAffilations;
    }

    public void setOrderedAffilations(OrderedAffilations orderedAffilations) {
        this.orderedAffilations = orderedAffilations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id
                && Objects.equals(client, order.client)
                && Objects.equals(registrationDate, order.registrationDate)
                && Objects.equals(appointmentDate, order.appointmentDate)
                && Objects.equals(executionDate, order.executionDate)
                && Objects.equals(employeesInOrder, order.employeesInOrder)
                && Objects.equals(orderedServices, order.orderedServices)
                && Objects.equals(orderedAffilations, order.orderedAffilations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                client,
                registrationDate,
                appointmentDate,
                executionDate,
                employeesInOrder,
                orderedServices,
                orderedAffilations);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", registrationDate=" + registrationDate +
                ", appointmentDate=" + appointmentDate +
                ", executionDate=" + executionDate +
                ", employeesInOrder=" + employeesInOrder +
                ", orderedServices=" + orderedServices +
                ", orderedAffilations=" + orderedAffilations +
                '}' + '\n';
    }
}
