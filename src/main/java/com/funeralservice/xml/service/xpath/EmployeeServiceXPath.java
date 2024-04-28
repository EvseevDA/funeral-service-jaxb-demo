package com.funeralservice.xml.service.xpath;

import com.funeralservice.dao.AbstractDao;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import java.util.*;

public class EmployeeServiceXPath extends AbstractDao<List<NodeNameValuePair>> {

    /**
     * List<'NodeNameValuePair'> consists only 1 employee <br>
     * List<'List <'NodeNameValuePair'>'> consists all employees
     *
     * @return all employees
     */
    @Override
    public List<List<NodeNameValuePair>>
    getAll() {
        Set<List<NodeNameValuePair>> result = new LinkedHashSet<>();
        Optional<List<List<NodeNameValuePair>>> temp;
        int id = 0;
        while ((temp = getByOrderId(id++)).get().isEmpty() == false) {
            result.addAll(temp.get());
        }
        return result.stream().toList();
    }

    /**
     * Instead of this use getByOrderId(int)
     *
     * @throws UnsupportedOperationException always
     */
    @Override
    public Optional<List<NodeNameValuePair>>
    getById(int id) {
        throw new UnsupportedOperationException("use getByOrderId(int)");
    }

    /**
     * @param id order id from which need to get employees
     * @return optional list of employees
     */
    public Optional<List<List<NodeNameValuePair>>>
    getByOrderId(int id) {
        Optional<List<List<NodeNameValuePair>>> result;
        try {
            XPathExpression xPathExpression = XmlServiceXPath.xPath.compile(
                    // path to employees in order with this id
                    XmlServiceXPath.pathToOrderWithId(id) + "/employeesInOrder/employeeInOrder/employee"
            );
            // get employees
            NodeList nodeList = (NodeList) xPathExpression.evaluate(XmlServiceXPath.document, XPathConstants.NODESET);
            int nodeCount = nodeList.getLength();
            List<List<NodeNameValuePair>> employees = new ArrayList<>();
            for (int i = 0; i < nodeCount; i++) {
                List<NodeNameValuePair> employee = new ArrayList<>();
                // get employee info
                NodeList children = nodeList.item(i).getChildNodes();
                int childCount = children.getLength();
                // get all node names and node values of employee
                for (int j = 1; j < childCount; j += 2) {
                    Node item = children.item(j);
                    employee.add(new NodeNameValuePair(item.getNodeName(), item.getTextContent()));
                }
                employees.add(employee);
            }
            result = Optional.of(employees);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * @param orderId    order id from which need to get employee
     * @param employeeId needed employee id
     * @return optional list which presents employee
     */
    public Optional<List<NodeNameValuePair>>
    getByOrderIdAndEmployeeId(int orderId, int employeeId) {
        AbstractDao.requireIdNonNegative(employeeId);
        Optional<List<NodeNameValuePair>> result;
        try {
            XPathExpression xPathExpression = XmlServiceXPath.xPath.compile(
                    // path to employee with employeeId in order with orderId
                    XmlServiceXPath.pathToOrderWithId(orderId) +
                            "/employeesInOrder/employeeInOrder/employee[@employeeId=" + employeeId + "]"
            );
            // get employee
            NodeList nodeList = (NodeList) xPathExpression.evaluate(XmlServiceXPath.document, XPathConstants.NODESET);
            // get employee info
            NodeList children = nodeList.item(0).getChildNodes();
            int childCount = children.getLength();
            List<NodeNameValuePair> employee = new ArrayList<>();
            // get all node names and node values of employee
            for (int j = 1; j < childCount; j += 2) {
                Node item = children.item(j);
                employee.add(new NodeNameValuePair(item.getNodeName(), item.getTextContent()));
            }
            result = Optional.of(employee);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
