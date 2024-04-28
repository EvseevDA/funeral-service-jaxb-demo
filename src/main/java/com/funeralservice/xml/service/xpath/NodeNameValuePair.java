package com.funeralservice.xml.service.xpath;

import java.util.Objects;

public class NodeNameValuePair {

    private String nodeName;
    private String nodeValue;

    public NodeNameValuePair() {
    }

    public NodeNameValuePair(String nodeName, String nodeValue) {
        this.nodeName = nodeName;
        this.nodeValue = nodeValue;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeNameValuePair that = (NodeNameValuePair) o;
        return Objects.equals(nodeName, that.nodeName) && Objects.equals(nodeValue, that.nodeValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeName, nodeValue);
    }

    @Override
    public String toString() {
        return "{" +
                "nodeName='" + nodeName + '\'' +
                ", nodeValue='" + nodeValue + '\'' +
                '}';
    }
}
