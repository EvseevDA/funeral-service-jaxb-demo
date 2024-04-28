package com.funeralservice.xml.service.jaxb;

import com.funeralservice.dao.AbstractDao;
import com.funeralservice.dao.AbstractEmployeeDao;
import com.funeralservice.pojo.Employee;
import com.funeralservice.pojo.EmployeeInOrder;
import com.funeralservice.pojo.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeServiceJaxb extends AbstractEmployeeDao {

    private final List<Order> orders = XmlServiceJaxb.getOrderList();

    @Override
    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();
        orders.forEach(o -> {
            List<EmployeeInOrder> employeeInOrderList = getEmployeeInOrder(o);
            employeeInOrderList.forEach(e -> {
                if (result.contains(e.getEmployee()) == false) {
                    result.add(e.getEmployee());
                }
            });
        });

        return result;
    }

    @Override
    public Optional<Employee> getById(int id) {
        AbstractDao.requireIdNonNegative(id);

        for (Order o : orders) {
            List<EmployeeInOrder> employeeInOrderList = getEmployeeInOrder(o);
            for (EmployeeInOrder e : employeeInOrderList) {
                if (e.getEmployee().getId() == id) {
                    return Optional.of(e.getEmployee());
                }
            }
        }
        return Optional.empty();
    }

    private static List<EmployeeInOrder> getEmployeeInOrder(Order order) {
        return Objects.requireNonNull(order).getEmployeesInOrder().getEmployeeInOrder();
    }
}
