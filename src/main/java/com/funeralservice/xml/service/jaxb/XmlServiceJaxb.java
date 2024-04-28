package com.funeralservice.xml.service.jaxb;

import com.funeralservice.pojo.FuneralService;
import com.funeralservice.pojo.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

final class XmlServiceJaxb {

    private XmlServiceJaxb() {
        throw new AssertionError("No com.funeralservice.xml.service.jaxb.XmlServiceJaxb instances for you!");
    }

    private static final FuneralService FUNERAL_SERVICE;
    private static final String XML_FILE_URL = "C:\\Users\\Salam\\IdeaProjects\\FuneralService\\dataBase.xml";

    static {
        try (FileReader reader = new FileReader(XML_FILE_URL)) {
            JAXBContext context = JAXBContext.newInstance(FuneralService.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FUNERAL_SERVICE = (FuneralService) unmarshaller.unmarshal(reader);
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static FuneralService getFuneralServiceInstance() {
        return FUNERAL_SERVICE;
    }

    public static List<Order> getOrderList() {
        return FUNERAL_SERVICE.getOrders().getOrder();
    }

}
