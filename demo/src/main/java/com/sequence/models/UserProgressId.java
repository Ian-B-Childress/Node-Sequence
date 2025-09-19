package com.sequence.models;


import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserProgressId implements Serializable {

    public Integer userId;
    public Integer nodeId;


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof UserProgressId that)) return false;
        return Objects.equals(userId, that.userId) && Objects.equals(nodeId, that.nodeId);
    }
    @Override
    public int hashCode(){
        return Objects.hash(userId, nodeId);
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }
}
