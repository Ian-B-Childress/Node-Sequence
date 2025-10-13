package com.sequence.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Node {



    //using Integer cause I know this wont surpass even a few hundred
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String type;
    private String content;
    private String status;


    public Node(Integer id, String code, String type, String content, String status) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.content = content;
        this.status = status;
    }

    public Node(){}

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Node: id= " + id + ", code= " + code + ", type= " + type + ", content= " + content + ", status= " + status;
    }

}
