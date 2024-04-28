package com.funeralservice.xml.service.xpath;

import com.funeralservice.dao.AbstractDao;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class XmlServiceXPath {

    private static final String FILE_REFERENCE = "C:\\Users\\Salam\\IdeaProjects\\FuneralService\\dataBase.xml";
    public static final Document document;
    public static final XPath xPath;

    static {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder;
        try {
            builder = builderFactory.newDocumentBuilder();
            document = builder.parse(FILE_REFERENCE);
            XPathFactory xPathFactory = XPathFactory.newInstance();
            xPath = xPathFactory.newXPath();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String pathToOrderWithId(int id) {
        return "/funeralService/orders/order[@orderId=" + AbstractDao.requireIdNonNegative(id) + "]";
    }
}
