package com.huai.web.pojo;

import java.util.HashMap;

import java.util.Map;

/**
 * Created by liangyh on 3/19/2017.
 */
public class Graph {

    private Map<String, Map<String, Vertex>> matrix = new HashMap<>();
    private Map<String, Consumer> networkToConsumer = new HashMap<>();
    private DataSet dataSet;

    public Graph(DataSet dataSet) {
        if (dataSet == null || dataSet.getConsumerNum() < 0
                || dataSet.getNetworkNum() < 0) throw new IllegalArgumentException();
        this.dataSet = dataSet;
        addMatrix();
        addConsumers();
    }

    public void addUndirectedMatrix(String start, String end, int volume, int cost){
        addMatrix(start, end, volume, cost);
        addMatrix(end, start, volume, cost);
    }

    private void addMatrix(String start, String end, int volume, int cost){
        if(!this.matrix.containsKey(start)){
            Map<String, Vertex> neighbors = new HashMap<>();
            neighbors.put(end, new Vertex(end, volume, cost));
            this.matrix.put(start, neighbors);
        }else {
            this.matrix.get(start).put(end, new Vertex(end, volume, cost));
        }
    }


    public void addMatrix(){
        for(Relationship relationship: this.dataSet.getRelationshipSet()){
            addUndirectedMatrix(relationship.getSource(), relationship.getTarget(),
                    relationship.getWeight(), relationship.getCost());
        }
    }

    public void addConsumers(){
        for(Consumer consumer: this.dataSet.getConsumerSet()){
            this.networkToConsumer.put(consumer.getNetworkId(), consumer);
        }
    }

    public Map<String, Consumer> getNetworkToConsumer() {
        return networkToConsumer;
    }

    public Map<String, Map<String, Vertex>> getMatrix() {
        return matrix;
    }

}
