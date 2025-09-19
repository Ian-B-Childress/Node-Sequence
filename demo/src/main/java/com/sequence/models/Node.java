package com.sequence.models;

public class Node {

    public int nodeId;
    public String nodeCode;
    public String nodeType;
    public String nodeContent;
    public String nodeStatus;


    public Node(int nodeId, String nodeCode, String nodeType, String nodeContent, String nodeStatus) {
        this.nodeId = nodeId;
        this.nodeCode = nodeCode;
        this.nodeType = nodeType;
        this.nodeContent = nodeContent;
        this.nodeStatus = nodeStatus;
    }

    public Node(){}

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeContent() {
        return nodeContent;
    }

    public void setNodeContent(String nodeContent) {
        this.nodeContent = nodeContent;
    }

    public String getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(String nodeStatus) {
        this.nodeStatus = nodeStatus;
    }
}
