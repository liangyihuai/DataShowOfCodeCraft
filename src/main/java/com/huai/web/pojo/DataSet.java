package com.huai.web.pojo;

import java.util.List;
import java.util.Set;

/**
 * Created by liangyh on 3/23/2017.
 */
public class DataSet {
    private Set<Relationship> relationshipSet;
    private int consumerNum;
    private int networkNum;
    private List<Node> nodeList;
    private Set<Consumer> consumerSet;

    public DataSet(Set<Relationship> relationshipSet, int consumerNum, int networkNum) {
        this.relationshipSet = relationshipSet;
        this.consumerNum = consumerNum;
        this.networkNum = networkNum;
    }

    public Set<Consumer> getConsumerSet() {
        return consumerSet;
    }

    public void setConsumerSet(Set<Consumer> consumerSet) {
        this.consumerSet = consumerSet;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public Set<Relationship> getRelationshipSet() {
        return relationshipSet;
    }

    public void setRelationshipSet(Set<Relationship> relationshipSet) {
        this.relationshipSet = relationshipSet;
    }

    public int getConsumerNum() {
        return consumerNum;
    }

    public void setConsumerNum(int consumerNum) {
        this.consumerNum = consumerNum;
    }

    public int getNetworkNum() {
        return networkNum;
    }

    public void setNetworkNum(int networkNum) {
        this.networkNum = networkNum;
    }
}
