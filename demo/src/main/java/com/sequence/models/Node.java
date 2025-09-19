package com.sequence.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Node {



    //using Integer cause I know this wont surpass even a few hundred
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nodeId;
    private String nodeCode;
    private String nodeType;
    private String nodeContent;
    private String nodeStatus;


    public Node(Integer nodeId, String nodeCode, String nodeType, String nodeContent, String nodeStatus) {
        this.nodeId = nodeId;
        this.nodeCode = nodeCode;
        this.nodeType = nodeType;
        this.nodeContent = nodeContent;
        this.nodeStatus = nodeStatus;
    }

    public Node(){}

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
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
