package com.funeralservice.xml.service.xpath;

import com.funeralservice.dao.AbstractDao;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceXPath extends AbstractDao<List<NodeNameValuePair>> {

    /**
     * List<'NodeNameValuePair'> consists only 1 client <br>
     * List<'List <'NodeNameValuePair'>'> consists all clients
     *
     * @return all clients
     */
    @Override
    public List<List<NodeNameValuePair>>
    getAll() {
        List<List<NodeNameValuePair>> result = new ArrayList<>();
        int id = 0;
        Optional<List<NodeNameValuePair>> optionalClient;
        while ((optionalClient = getById(id++)).isEmpty() == false) {
            List<NodeNameValuePair> client = optionalClient.get();
            // duplicates are not allowed
            if (result.contains(client) == false) {
                result.add(client);
            }
        }
        return result;
    }

    /**
     * @param id is order id from which need to get the client
     * @return the client as optional List of NodeNameValuePair
     */
    @Override
    public Optional<List<NodeNameValuePair>>
    getById(int id) {
        AbstractDao.requireIdNonNegative(id);
        List<NodeNameValuePair> result = new ArrayList<>();
        XPathExpression xPathExpression;

        try {
            xPathExpression = XmlServiceXPath.xPath.compile(
                    // Path to client of needed order
                    XmlServiceXPath.pathToOrderWithId(id) + "/client"
            );
            // get client
            NodeList nodeList = (NodeList) xPathExpression.evaluate(XmlServiceXPath.document, XPathConstants.NODESET);
            // if client not found (if no such order with this id)
            if (nodeList.getLength() == 0) {
                return Optional.empty();
            }
            // get client info
            NodeList children = nodeList.item(0).getChildNodes();
            int nodeCount = children.getLength();
            // add all node names and node values of client
            for (int i = 1; i < nodeCount; i += 2) {
                Node item = children.item(i);
                result.add(new NodeNameValuePair(item.getNodeName(), item.getTextContent()));
            }
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(result);
    }
}
