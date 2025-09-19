package com.sequence.models;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
public class UserProgress  {


    @EmbeddedId
    private UserProgressId id;

    @ManyToOne
    //map this field to userId inside the embedded id
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    //same deal ^ map nodeId
    @MapsId("nodeId")
    @JoinColumn(name = "node_id")
    private Node node;


    private Timestamp timestamp;
    private String status;

    public UserProgress(Users users, Node node, Timestamp timestamp, String status) {
        this.users = users;
        this.node = node;
        this.timestamp = timestamp;
        this.status = status;
    }

    public UserProgress(){}


    public UserProgressId getId() {
        return id;
    }

    public void setId(UserProgressId id) {
        this.id = id;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
