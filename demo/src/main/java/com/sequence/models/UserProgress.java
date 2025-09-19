package com.sequence.models;

import java.sql.Timestamp;

public class UserProgress {
    public int userId;
    public int nodeId;
    public Timestamp timestamp;
    public String status;

    public UserProgress(int userId, int nodeId, Timestamp timestamp, String status) {
        this.userId = userId;
        this.nodeId = nodeId;
        this.timestamp = timestamp;
        this.status = status;
    }

    public UserProgress(){}


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
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
