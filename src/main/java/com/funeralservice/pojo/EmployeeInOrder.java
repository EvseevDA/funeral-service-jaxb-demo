package com.funeralservice.pojo;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employeeInOrder", propOrder = {
        "employee"
})
public class EmployeeInOrder {
    @XmlElement(name = "employee")
    private Employee employee;

    public EmployeeInOrder() {
    }

    public EmployeeInOrder(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeInOrder that = (EmployeeInOrder) o;
        return Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee);
    }

    @Override
    public String toString() {
        return "EmployeeInOrder{" +
                "employee=" + employee +
                '}' + '\n';
    }
}
